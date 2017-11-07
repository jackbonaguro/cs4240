package com.tiger.compiler.parser;

import com.tiger.compiler.TokenTuple;
import com.tiger.compiler.Token;
import com.tiger.compiler.parser.GrammarToken;
import com.tiger.compiler.parser.Nonterminal;
import com.tiger.compiler.parser.ParsingTable;
import com.tiger.compiler.parser.SemanticAction;

import java.util.Stack;
import java.util.List;

public class Analyzer {

	private Stack<GrammarToken> parserStack;

	//Private data structures
	public Stack<IdStackEntry> idStack;
	public boolean idStackConst;

	public Analyzer(Stack<GrammarToken> parserStack) {
		this.parserStack = parserStack;
		this.idStack = new Stack<IdStackEntry>();
		this.idStackConst = false;
	}

	public void analyze(SemanticAction sa) {
		//System.out.println("################\t"+sa);
		switch (sa) {
			case IDSTACK_PUSH_ID:
				this.idstack_push_id();
		}
	}

	private void idstack_push_id() {
		//Only comes after an id, otherwise error will bubble up
		Token id = (Token) parserStack.peek();
		IdStackEntry a = new IdStackEntry();
		a.name = id.label;
		a.isId = true;
		idStack.push(a);
	}
}