package com.tiger.compiler.parser;

import com.tiger.compiler.scanner.TigerScanner;

public class TigerParser {

	private TigerScanner scanner;

	public TigerParser(TigerScanner s) {
		this.scanner = s;
	}

	public void parse() {
		System.out.println("This is the parse method.");

		scanner.next();
	}
}