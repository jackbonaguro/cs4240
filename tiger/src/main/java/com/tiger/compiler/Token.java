package com.tiger.compiler;

import com.tiger.compiler.scanner.DfaState;

public enum Token{
	COMMA, COLON, SEMI, LPAREN, RPAREN, LBRACK, RBRACK, LBRACE, RBRACE, 
	PERIOD, PLUS, MINUS, MULT, DIV, EQ, NEQ, LESSER, GREATER, LESSEREQ,
	GREATEREQ, AND, OR, ASSIGN, ARRAY, RECORD, BREAK, DO, ELSE, END, FOR,
	FUNC, IF, IN, LET, OF, THEN, TO, TYPE, VAR, WHILE, ENDIF, BEGIN,
	ENDDO, ID, INTLIT, FLOATLIT, WHITESPACE, ERROR, COMMENT, EOF;

	public String label;

	public static Token classOf(DfaState state, String str) {
		int stateNum = state.getId();

		switch(stateNum) {
			case 1:
				return PERIOD;
			case 27:
				return classOfIdentifier(str);
			case 31:
				return WHITESPACE;
			default:
				return ERROR;
		}
	}

	public static Token classOfIdentifier(String identifier) {
		switch(identifier) {
			case "let":
				return LET;
			case "type":
				return TYPE;
			case "array":
				return ARRAY;
			case "record":
				return RECORD;
			case "break":
				return BREAK;
			case "do":
				return DO;
			case "else":
				return ELSE;
			case "end":
				return END;
			case "for":
				return FOR;
			case: "func":
			        return FUNC;
			case "if":
			        return IF;
			case "in":
			        return IN;
			case "then":
			        return THEN;
			case "to":
			        return TO;
			case "var":
			        return VAR;
			case "while":
			        return WHILE;
			case "endif":
			        return ENDIF;
			case "begin":
			        return BEGIN;
			case "enddo":
			        return ENDDO;
			default:
				return ID;
		}
	}

}
