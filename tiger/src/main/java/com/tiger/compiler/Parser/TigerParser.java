package com.tiger.compiler.parser;

import com.tiger.compiler.scanner.TigerScanner;
import com.tiger.compiler.TokenTuple;
import com.tiger.compiler.Token;

public class TigerParser {

	private TigerScanner scanner;

	public TigerParser(TigerScanner s) {
		this.scanner = s;
	}

	public void parse() {
		GrammarToken focus;
		GrammarToken lookAhead;

		System.out.println("This is the parse method.");
		Stack<GrammarToken> stack = new Stack<GrammarToken>();
		TokenTuple token = this.scanner.next();


		stack.push(); //push EOF token onto stack
		stack.push(); //push start symbol onto stack, production tiger program


		while(true) {
			if(focus == Token.EOF && lookAhead == Token.EOF) {
				// parsing is complete, both lookahead and current element of stack are eof
				System.out.println("Parse Succesful!");
				break;
			} else if(focus || focus == Token.EOF) { // check if focus is a terminal symbol, 
				if(focus == lookahead) {
					stack.pop();
					token = this.scanner.next();
					lookahead = ; //get the next word
				} else {
					System.out.println("Error looking for symbol at top of stack.");
				}
			} else {
				//focus is a nonterminal
				if() { //we loop up in our ll(1) parse table to check if we can expand a production rule
					stack.pop();
					// loop through the production rule RHS 
					for(GrammarToken t : list) { //TODO: loop backwards
						if (t != null) {
							stack.push(t);
						}
					}
				} else {
					System.out.println("Error expanding focus.");
				}
			}
			focus = stack.peek();


		}


		
	}
}