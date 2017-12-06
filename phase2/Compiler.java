import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

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

		while(scan.hasNextLine()) {
			file.add(scan.nextLine());
		}
		//System.out.println(file);

		for (String l: file) {
			IROperation iro = new IROperation();
			//First check for labels
			if l.substring(l.length() - 2, l.length() - 1).equals(":") {
				iro = new LabelOperation(l.substring(0, l.length() - 1));
			}
			//Otherwise split by arguments and find op name
			else {
				String[] line = l.split(",");
				for (String i: line) {
					i = i.trim();
				}
				switch (line[0]) {
					case "assign":
						if (line.length == 3) {
							//Regular Assign
							iro = new AssignOperation(line[1],line[2]);
						} else {
							//Array Assign
							iro = new ArrayAssignOperation(line[1],
								line[2],line[3]);
						}
					break;
				}
			}

			iros.add(iro);
		}
	}
}