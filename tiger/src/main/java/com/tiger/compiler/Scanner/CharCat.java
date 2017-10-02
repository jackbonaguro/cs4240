package com.tiger.compiler.scanner;

public enum CharCat {
	COMMA,
	COLON,
	SEMICOLON,
	LPAREN,
	RPAREN,
	LBRACK,
	RBRACK,
	LBRACE,
	RBRACE,
	PERIOD,
	PLUS,
	MINUS,
	MULT,
	DIV,
	EQ,
	EXCL,
	LESSER,
	GREATER,
	AND,
	OR,
	LETTER,
	UNDERSCORE,
	ZERO,
	NUMNOTZERO,
	WHITESPACE,
	OTHER;

	public CharCat classOf(char c) {
		if(Character.isWhitespace(c)) {
			return WHITESPACE;
		} else if(Character.isLetter(c)) {
			return LETTER;
		}

		switch(c) {
			case ',':
				return COMMA;
			case ':':
				return COLON;
			case ';':
				return SEMICOLON;
			case '(':
				return LPAREN;
			case ')':
				return RPAREN;
			case '[':
				return LBRACK;
			case ']':
				return RBRACK;
			case '{':
				return LBRACE;
			case '}':
				return RBRACE;
			case '.':
				return PERIOD;
			case '+':
				return PLUS;
			case '-':
				return MINUS;
			case '*':
				return MULT;
			case '/':
				return DIV;
			case '=':
				return EQ;
			case '!':
				return EXCL;
			case '<':
				return LESSER;
			case '>':
				return GREATER;
			case '&':
				return AND;
			case '|':
				return OR;
			case '_':
				return UNDERSCORE;
			case '0':
				return ZERO;
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				return NUMNOTZERO;

			default:
				return OTHER;

		}
	}
}
