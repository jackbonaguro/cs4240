import java.io.*;
import java.util.Scanner;

public class Comp {
	public static void main(String[] args) throws IOException {
		String filepath = args[0];
		Scanner sc = new Scanner(new File(filepath));
		//sc.useDelimiter("");
		while(sc.hasNext()) {
			String c = sc.next();
			if (c.equals("\t") || c.equals("\n") || c.equals(" ")) {
				System.out.print("\n");
			} else {
				System.out.print(c + "\n");
			}
		}
	}
}