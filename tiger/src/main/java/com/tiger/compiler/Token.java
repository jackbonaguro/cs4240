package com.tiger.compiler;

import com.tiger.compiler.scanner.DfaState;
import com.tiger.compiler.GrammarToken;

public enum Token implements GrammarToken{
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
			case 2:
				return COMMA;
			case 3:
				return COLON;
			case 4:
				return SEMI;
			case 5:
				return LPAREN;
			case 6:
				return RPAREN;
			case 7:
				return LBRACK;
			case 8:
				return RBRACK;
			case 9:
				return LBRACE;
			case 10:
				return RBRACE;
			case 11:
				return PLUS;
			case 12:
				return MINUS;
			case 13:
				return MULT;
			case 14:
				return DIV;
			case 15:
				return EQ;
			case 16:
				return LESSER;
			case 17:
				return NEQ;
			case 18:
				return LESSEREQ;
			case 19:
				return GREATER;
			case 20:
				return ASSIGN;
			//Not finished
			//case 21:
			//Excl should be removed from table
			case 22:
				return OR;
			case 23:
				return AND;
			case 26:
				return COMMENT;
			case 27:
				return classOfIdentifier(str);
			//Not finished
			//Literal states must be added
			case 29:
				return INTLIT;
			case 30:
				return FLOATLIT;
			case 31:
				return WHITESPACE;
			//Not finished
			//case 32:
			//Excl should be removed from table
			case 33:
				return GREATEREQ;
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
			case "function":
			        return FUNC;
			case "if":
			        return IF;
			case "in":
			        return IN;
			case "of":
			        return OF;
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
