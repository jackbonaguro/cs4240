public class Token{
	private String name;
	private TokenType type;

	public Token(String name, TokenType type) {
		this.name = name;
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(TokenType type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public TokenType getType() {
		return this.type;
	}

	public String toString() {
		return "Token(\"" + this.name + "\"," + this.type + ")";
	}
}