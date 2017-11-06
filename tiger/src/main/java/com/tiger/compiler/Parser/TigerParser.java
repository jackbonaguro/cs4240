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

		for (int i = 0; i < 30; i++) {
			try {
				System.out.println(this.scanner.next());
			} catch (RuntimeException re) {
				System.err.println(re);
			}
		}
	}
}