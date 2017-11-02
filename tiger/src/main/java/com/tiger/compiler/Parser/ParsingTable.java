package com.tiger.compiler.parser.ParsingTable;

public class ParsingTable {
	public HashMap<GrammarToken, HashMap<Token, Int>> table;	

	public ParsingTable() {

	}

	public boolean productionExpansionExists(GrammarToken production, GrammarToken terminal) {
		//return true if a number exists
		//return false if error 
	}

	public int getProductionNumber(GrammarToken production, GrammarToken terminal) {
		//return the number associated with the production rule to expand
	} 
}