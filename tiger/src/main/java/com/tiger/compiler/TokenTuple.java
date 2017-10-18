package com.tiger.compiler;

import com.tiger.compiler.Token;

public class TokenTuple{
	private String name;
	private Token token;

	public TokenTuple(String name, Token type) {
		this.name = name;
		this.token = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(Token type) {
		this.token = type;
	}

	public String getName() {
		return this.name;
	}

	public Token getType() {
		return this.token;
	}

	public String toString() {
		return "Token(\"" + this.name + "\"," + this.token + ")";
	}
}