import java.io.*;
import java.util.Scanner;

public class Comp {
	public static void main(String[] args) throws IOException {
		String filepath = args[0];

		Scanner sc = new Scanner(new File(filepath));
		sc.useDelimiter("");

		String current = "";
		Token prev = new Token("",null);
		String c = "";
		int i = 0;
		boolean proceed = true;
		boolean substring = false;

		while(sc.hasNext()) {
			i++;

			if (proceed) {
				c = sc.next();
			}

			
			TokenType tt = null;

			//System.out.println("'" + c + "'");
			if (c.equals("\n") || c.equals("\t") || c.equals(" ")) {
				continue;
			}

			prev.setName(current);
			current = current + c;

			//System.out.println("C: " + c);
			//System.out.println("Current: " + current);
			//System.out.println("i: " + i);

			substring = false;	//We can discard current if it won't lead to a
								//valid token
			for (TokenType type: TokenType.values()) {
				//System.out.print(type.label);
				//System.out.print(", ");
				//System.out.print(current);
				if (type.label.equals(current)) {
					tt = TokenType.valueOf(type.name());
					//System.out.println(tt.getClass());
				} else if (current.length() < type.label.length() && current
					.equals(type.label.substring(0,current.length()))) {
					substring = true;
				}
			}
			if (tt == null) {
				//Now check for id/literal types
			}

			//If tt is still null, then prev was the longest token
			if (tt == null && prev.getType() != null) {
				// *RETURN*
				System.out.println(prev);
				current = "";
				prev = new Token("",null);
				proceed = false;
			} else if (tt == null) {
				if (!substring) {
					//This is where you'd throw an error: No valid substring
					// can be made so we reset current
					System.out.println("\nError parsing symbol: "
						+ prev.getName() + "\n");

					current = "";
					prev.setName("");
				}
				proceed = true;
			} else {
				proceed = true;
				prev.setType(tt);
			}
		}
		//At end of file, must return last valid token
		prev.setName(prev.getName() + c);
		for (TokenType type: TokenType.values()) {
			if (type.label.equals(prev.getName())) {
					prev.setType(TokenType.valueOf(type.name()));
			}	//No need to check for substring, it won't lead to valid token
		}
		if (prev.getType() == null) {
			//Now check for id/literal types
		}
		System.out.println(prev);
	}
}