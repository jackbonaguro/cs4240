package com.tiger.compiler.parser;

import com.tiger.compiler.scanner.TigerScanner;
import com.tiger.compiler.TokenTuple;
import com.tiger.compiler.Token;
import com.tiger.compiler.parser.GrammarToken;
import com.tiger.compiler.parser.Nonterminal;
import com.tiger.compiler.parser.ParsingTable;
import com.tiger.compiler.parser.SemanticAction;

import java.util.Stack;
import java.util.List;

public class TigerParser {

	private TigerScanner scanner;
	private ParsingTable table;
	//private Map<Integer, ProductionRule> production_rules;

	public TigerParser(TigerScanner s) {
		this.scanner = s;
		this.table = new ParsingTable();
		//this.production_rules = new 
	}

	public void parse() {
		GrammarToken focus;
		GrammarToken lookAhead;

		System.out.println("This is the parse method.");
		Stack<GrammarToken> stack = new Stack<GrammarToken>();
		Analyzer analyzer = new Analyzer(stack);
		TokenTuple token = this.scanner.next();

		lookAhead = token.getType();


		stack.push(Token.EOF); //push EOF token onto stack
		stack.push(Nonterminal.TIGER_PROGRAM); //push start symbol onto stack, production tiger program

		focus = stack.peek();

		while(true) {
			System.out.println("Focus:" + focus);
			System.out.println("lookAhead:" + lookAhead);
			System.out.println("stack:" + stack);


			if(focus == Token.EOF && lookAhead == Token.EOF) {
				// parsing is complete, both lookahead and current element of stack are eof
				System.out.println("Parse Succesful!");
				break;
			} else if(focus instanceof Token || focus == Token.EOF) { // check if focus is a terminal symbol, 
				if(focus == lookAhead) {
					GrammarToken removedGrammarToken = stack.pop();
					token = this.scanner.next();
					lookAhead = token.getType(); //get the next word
				} else {
					System.out.println("Error looking for symbol at top of stack.");
					System.out.println("focus: " + focus);
					System.out.println("lookAhead:" + lookAhead);
				}
			} else if (focus instanceof Nonterminal) {
				//focus is a nonterminal
				if(table.productionExpansionExists((Nonterminal) focus, lookAhead)) { //we loop up in our ll(1) parse table to check if we can expand a production rule
					ProductionRule prod = table.getProduction(focus, lookAhead);


					List<GrammarToken> rhs = prod.getRhs();
					stack.pop();
					for(int i = rhs.size() - 1; i >= 0; i--) {
						if(rhs.get(i) != Token.NULL) {
							stack.push(rhs.get(i));
						}
					}

					
				} else {
					System.out.println("Error expanding focus.");
					break;
				}
			} else if (focus instanceof SemanticAction) {
				//focus is a semantic action
				GrammarToken removedGrammarToken = stack.pop();
				analyzer.analyze((SemanticAction) focus);
			}
			focus = stack.peek();

		}


	}
}