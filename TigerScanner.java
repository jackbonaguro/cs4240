import java.io.*;
import java.util.Scanner;
import java.io.EOFException;

public class TigerScanner {
	private TigerScannerDFA dfa;
	private Scanner sc;

	private int currentState;
	private String currentName;

	private int lineNumber;
	private String prefix;

	private boolean valid;
	private String c;

	public TigerScanner(String filename) {
		this.dfa = new TigerScannerDFA();
		try {
			this.sc = new Scanner(new File(filename));
		} catch (Exception e) {
			System.out.println(e);
		}
			this.sc.useDelimiter("");

		this.currentState = 0;
		this.currentName = "";

		this.lineNumber = 0;
		this.prefix = "";

		this.valid = false;
		if(this.sc.hasNext()){
			this.c = sc.next();
		}
	}

	public Token next() throws EOFException, Exception {
		/* Four Cases for loop:
			I. invalid->invalid: return nothing, continue invalid token
			II. invalid->valid: throw invalid token, start valid token
			III. valid->valid: return nothing, continue valid token
			IV. valid->invalid: return valid toke, start invalid token

			The loop executes until hitting II or IV, either returning
			or throwing an error. The second character in those cases will
			be carried over to the next loop
		*/
		currentState = 0;
		currentName = "";

		while (true) {
			if(this.sc.hasNext()) {

				if(c.equals("\n")) {
					lineNumber++;
					prefix = "";
				}

				TigerScannerDFA.DFAKey key = new TigerScannerDFA
						.DFAKey(currentState, c);
				TigerScannerDFA.DFAValue val = this.dfa.map.get(key);

				if (!valid) {
					if (val == null || !val.valid) {
						//Case I
						currentName += c;
					} else {
						//Case II
						valid = true;
						
						String oldprefix = prefix;
						prefix += currentName;

						throw new Exception("Line "
							+ lineNumber + ": " + oldprefix
							+ "\"" + currentName + "\"");
						//Since it throws, call ends here
					}
				} else {
					if (val != null || val.valid) {
						//Case III
						currentName += c;
					} else {
						//Case IV
						valid = false;

						prefix += currentName;

						TokenType tt = this.dfa.tokens.get(currentState);
						if(tt == null) {
							//No entry in dfa.tokens indicates a pass -
							//whitespace, comment, etc.
							//Thus we just get the next token.
							return this.next();
						}
						Token t = new Token(currentName, tt);
						return t;
						//Since it returns, call ends here
					}
				}

				c = this.sc.next();

			} else {
				throw new EOFException();
			}
		}
	}
}