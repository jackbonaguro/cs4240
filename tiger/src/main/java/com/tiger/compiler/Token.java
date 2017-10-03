package com.tiger.compiler;

public enum Token{
	COMMA(","),
	COLON(":"),
	SEMI(";"),
	LPAREN("("),
	RPAREN(")"),
	LBRACK("["),
	RBRACK("]"),
	LBRACE("{"),
	RBRACE("}"),
	PERIOD("."),
	PLUS("+"),
	MINUS("-"),
	MULT("*"),
	DIV("/"),
	EQ("="),
	NEQ("!="),
	LESSER("<"),
	GREATER(">"),
	LESSEREQ("<="),
	GREATEREQ(">="),
	AND("&"),
	OR("|"),
	ASSIGN(":="),
	ARRAY("ARRAY"),
	RECORD("RECORD"),
	BREAK("BREAK"),
	DO("D"),
	ELSE("ELSE"),
	END("END"),
	FOR("FOR"),
	FUNC("FUNC"),
	IF("IF"),
	IN("IN"),
	LET("LET"),
	OF("OF"),
	THEN("THEN"),
	TO("TO"),
	TYPE("TYPE"),
	VAR("VAR"),
	WHILE("WHILE"),
	ENDIF("ENDIF"),
	BEGIN("BEGIN"),
	ENDDO("ENDDO"),
	ID(""),
	INTLIT(""),
	FLOATLIT("");

	public String label;

	private Token(String label) {
		this.label = label;
	}
}