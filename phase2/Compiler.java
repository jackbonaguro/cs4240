import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Compiler{
	public static Scanner scan;
	public static ArrayList<String> file;
	public static ArrayList<IROperation> iros;

	public static void main(String[] args) {
		try {
			scan = new Scanner(new File(args[0]));
		} catch (FileNotFoundException fnfe) {
			System.err.println("File Not Found");
		}
		file = new ArrayList<String>();
		iros = new ArrayList<IROperation>();

		//Split file into lines
		while(scan.hasNextLine()) {
			file.add(scan.nextLine());
		}

		//Convert each line into an instance of IROperation
		for (String l: file) {
			IROperation iro = new IROperation();
			//First check for labels
			if (l.substring(l.length() - 2, l.length() - 1).equals(":")) {
				iro = new LabelOperation(l.substring(0, l.length() - 1));
			}
			//Otherwise split by arguments and find op name
			else {
				String[] line = l.split(",");
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
						//ArrayList<String> params = new ArrayList<String>();
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
						if (line[0].substring(0,2).equals("b")) {
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
							iro = BranchOperation(cond,line[1],line[2],line[3]);
						}
						break;
				}
			}

			iros.add(iro);
		}
	}
}