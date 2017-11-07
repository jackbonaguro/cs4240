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

	public void analyze(SemanticAction sa) throws Exception{
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

	public void idstack_pop_type() {
		String t;
		if(idStackConst) {
			String c;
			if(idStack.peek().isInt) {
				c = idStack.pop().name;
				t = idStack.pop().name;
				if (!t.equals("int")) {
					throw new Exception("Semantic Error");
				}
			} else {
				c = idStack.pop().name;
				t = idStack.pop().name;
				if (!t.equals("float")) {
					throw new Exception("Semantic Error");
				}
			}
		} else {
			t = idStack.pop().name;
		}
		while(idStack.peek().isId) {
			String i = idStack.pop().name;
			//add to id table with hash of type from typetable as typeid
			//id table must check if name is already used in that scope

		}
		//Code generation - makes use of c and idStackConst, then resets idStackConst
	}
}