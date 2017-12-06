import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Compiler{
	public static Scanner scan;
	public static ArrayList<String> file;
	public static ArrayList<IROperation> iros;
	public static ArrayList<String> generated;

	public static Allocation allocation;

	public static void main(String[] args) {
		try {
			scan = new Scanner(new File(args[0]));
		} catch (FileNotFoundException fnfe) {
			System.err.println("File Not Found");
		}
		file = new ArrayList<String>();
		iros = new ArrayList<IROperation>();
		generated = new ArrayList<String>();

		allocation = new Allocation(new ArrayList<String>(), 0);

		//Split file into lines
		while(scan.hasNextLine()) {
			file.add(scan.nextLine());
		}

		//Convert each line into an instance of IROperation
		for (String l: file) {
			IROperation iro;
			
			try {
				iro = matchOperation(l);
				iros.add(iro);
				System.out.println(iro);
			} catch (Exception e) {
				System.err.println(l + " could not be matched.");
			}
		}

		//Get a list of variables for the allocator
		for (IROperation iro: iros) {
			if (iro instanceof IntListOperation) {
				allocation.variables.addAll(((IntListOperation) iro).ints);
			} else if (iro instanceof FloatListOperation) {
				allocation.variables.addAll(((FloatListOperation) iro).floats);
			}
		}
		System.out.println("\nVariables: "+allocation.variables);


		//Now do code generation
		for (IROperation iro: iros) {
			generated.add(iro.generate(allocation));
		}
	}

	public static IROperation matchOperation(String l) throws Exception {
		IROperation iro;
		//First check for labels
		if (l.substring(l.length() - 1, l.length()).equals(":")) {
			
			/*	NOTE:	*/
			//Since this just checks for end-line colon,
			//it will also catch an empty int-list
			// or float-list.
			//Unclear how to resolve this.

			iro = new LabelOperation(l.substring(0, l.length() - 1));
			return iro;
		}
		else {
			//Maybe it's an int/float list?
			String[] line;
			line = l.split(":");
			//System.out.println(Arrays.toString(line));
			for (String i: line) {
				i = i.trim();
			}
			String[] list;
			switch (line[0]) {
				case "int-list":
					//Split the list and add to ints
					ArrayList<String> ints = new ArrayList<String>();
					list = line[1].split(",");
					for (String i: list) {
						i = i.trim();
						ints.add(i);
					}
					return new IntListOperation(ints);
				case "float-list":
					//System.out.println(line);
					//Split the list and add to ints
					ArrayList<String> floats = new ArrayList<String>();
					list = line[1].split(",");
					for (String i: list) {
						i = i.trim();
						floats.add(i);
					}
					return new FloatListOperation(floats);
				//end switch
			}

			//Otherwise split by arguments and find op name
			line = l.split(",");
			//System.out.println(Arrays.toString(line));
			for (String i: line) {
				i = i.trim();
			}
			ArrayList<String> params = new ArrayList<String>();
			switch (line[0]) {
				case "assign":
					if (line.length == 3 ||
						(line.length == 4 && line[3].equals(""))) {
						//Regular Assign
						iro = new AssignOperation(line[1],line[2]);
					} else {
						//Array Assign
						iro = new ArrayAssignOperation(line[1],
							line[2],line[3]);
					}
					break;
				case "add":
					iro = new AddOperation(line[1],
							line[2],line[3]);
					break;
				case "sub":
					iro = new SubOperation(line[1],
							line[2],line[3]);
					break;
				case "mult":
					iro = new MultOperation(line[1],
							line[2],line[3]);
					break;
				case "div":
					iro = new DivOperation(line[1],
							line[2],line[3]);
					break;
				case "and":
					iro = new AndOperation(line[1],
							line[2],line[3]);
					break;
				case "or":
					iro = new OrOperation(line[1],
							line[2],line[3]);
					break;
				case "goto":
					iro = new GotoOperation(line[1]);
					break;
				case "return":
					iro = new ReturnOperation(line[1]);
					break;
				case "call":
					//gArrayList<String> params = new ArrayList<String>();
					for (String p: line) {
						if (p == line[0]) continue;
						if (p == line[1]) continue;
						params.add(p);
					}
					iro = new CallOperation(line[1],params);
					break;
				case "callr":
					//ArrayList<String> params = new ArrayList<String>();
					for (String p: line) {
						if (p == line[0]) continue;
						if (p == line[1]) continue;
						if (p == line[2]) continue;
						params.add(p);
					}
					iro = new CallrOperation(line[1],line[2],params);
					break;
				case "array_store":
					iro = new ArrayStoreOperation(line[1],line[2],line[3]);
					break;
				case "array_load":
					iro = new ArrayLoadOperation(line[1],line[2],line[3]);
					break;
				default:
					if (line[0].substring(0,1).equals("b")) {
						//Branch operations
						String cond = line[0].substring(2,line[0].length());

						//replace IR condition with MIPS
						switch (cond) {
							case "":
								cond = "";
								break;
							case "eq":
								cond = "eq";
								break;
							case "neq":
								cond = "ne";
								break;
							case "lt":
								cond = "lt";
								break;
							case "gt":
								cond = "gt";
								break;
							case "geq":
								cond = "ge";
								break;
							case "leq":
								cond = "le";
								break;
						}
						iro = new BranchOperation(cond,line[1],line[2],line[3]);
					} else {
						//To combat not initialized exception.
						//Gets thrown out by exception anyways
						iro = new LabelOperation(line[0]);

						throw new Exception();
					}
					break;
				//end switch
			}
		}
		return iro;
	}
}