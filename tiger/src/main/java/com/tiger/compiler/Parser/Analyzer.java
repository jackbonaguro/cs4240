package com.tiger.compiler.parser;

import com.tiger.compiler.TokenTuple;
import com.tiger.compiler.Token;
import com.tiger.compiler.parser.GrammarToken;
import com.tiger.compiler.parser.Nonterminal;
import com.tiger.compiler.parser.ParsingTable;
import com.tiger.compiler.parser.SemanticAction;
import com.tiger.compiler.parser.TypeTable;
import com.tiger.compiler.parser.IdentifierTable;

import java.util.Stack;
import java.util.List;

public class Analyzer {

	private Stack<GrammarToken> parserStack;
	private TypeTable typeTable;
	private IdentifierTable identifierTable;

	//Private data structures
	public Stack<IdStackEntry> idStack;
	public boolean idStackConst;

	public Analyzer(Stack<GrammarToken> parserStack, TypeTable typeTable, IdentifierTable identifierTable) {
		this.parserStack = parserStack;
		this.typeTable = typeTable;
		this.identifierTable = identifierTable;

		//Analysis state variables
		this.idStack = new Stack<IdStackEntry>();
		this.idStackConst = false;
	}

	public void analyze(SemanticAction sa) throws Exception{
		System.out.println(sa);
		switch (sa) {
			case IDSTACK_PUSH_ID:
				this.idstack_push_id();
			case IDSTACK_PUSH_CONST: 
				this.idstack_push_const();
			case IDSTACK_PUSH_TYPE:
			    this.idstack_push_type();
			case IDSTACK_POP_TYPE:
				this.idstack_pop_type();
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

	private void idstack_push_type() {
		Token id = (Token) parserStack.peek();
		IdStackEntry a = new IdStackEntry();
		a.name = id.label;
		a.isType = true;
		idStack.push(a);
	}

	private void idstack_push_const() {
		this.idStackConst = true;
        Token id = (Token) parserStack.peek();
		IdStackEntry a = new IdStackEntry();
		a.name = id.label;
		a.isConst = true;
		if (id == Token.INTLIT) {
			a.isInt = true;
		}
		idStack.push(a);
		this.idStackConst = false;
	}

	public void idstack_pop_type() throws Exception{
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

		//Get type's hash from typetable
		int hash = 0;
		for (TypeTableEntry ent : typeTable.table.values()) {
	  		if (ent.name.equals(t)) {
	  			hash = ent.hashCode();
	  		}
	  	}

		while(idStack.peek().isId) {
			String i = idStack.pop().name;
			//add to id table with hash of type from typetable as typeid
			identifierTable.putEntry(i, hash);
		}

		//Code generation - makes use of c and idStackConst, then resets idStackConst
	}
}