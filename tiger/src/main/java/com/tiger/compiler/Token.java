package com.tiger.compiler;

import com.tiger.compiler.scanner.DfaState;

public enum Token{
	COMMA, COLON, SEMI, LPAREN, RPAREN, LBRACK, RBRACK, LBRACE, RBRACE, 
	PERIOD, PLUS, MINUS, MULT, DIV, EQ, NEQ, LESSER, GREATER, LESSEREQ,
	GREATEREQ, AND, OR, ASSIGN, ARRAY, RECORD, BREAK, DO, ELSE, END, FOR,
	FUNC, IF, IN, LET, OF, THEN, TO, TYPE, VAR, WHILE, ENDIF, BEGIN,
	ENDDO, ID, INTLIT, FLOATLIT, WHITESPACE, ERROR, COMMENT, EOF;

	public String label;

	private Token classOf(DfaState state, String str) {
		int stateNum = state.getId();

		switch(stateNum) {
			case 1:
				return PERIOD;
			case 27:
				switch(str) {
					case 'let':
						return LET;
				}
			default:
				return ERROR;
		}
	}
}