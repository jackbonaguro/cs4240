public class TigerScanner {
	private Scanner sc;
	int currentState;

	public TigerScanner(String filename) {
		this.sc = new Scanner(new File(filename));
		this.sc.useDelimiter("");

		this.currentState = 0;
	}

	public Token next() throws RuntimeException {
		if(sc.hasNext()) {
			String c = sc.next();
		}

		
	}
}