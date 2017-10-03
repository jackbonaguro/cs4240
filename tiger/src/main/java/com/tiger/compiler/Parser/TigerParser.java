package com.tiger.compiler.parser;

import com.tiger.compiler.scanner.TigerScanner;
import com.tiger.compiler.TokenTuple;

public class TigerParser {

	private TigerScanner scanner;

	public TigerParser(TigerScanner s) {
		this.scanner = s;
	}

	public void parse() {
		System.out.println("This is the parse method.");

		TokenTuple token = this.scanner.next();
		System.out.println("Token:" + token);
		 token = scanner.next();
		System.out.println("Token:" + token);
		 token = scanner.next();
		System.out.println("Token:" + token);
		 token = scanner.next();
		System.out.println("Token:" + token);
		 token = scanner.next();
		System.out.println("Token:" + token);
		 token = scanner.next();
		System.out.println("Token:" + token);
		 token = scanner.next();
		System.out.println("Token:" + token);
	}
}