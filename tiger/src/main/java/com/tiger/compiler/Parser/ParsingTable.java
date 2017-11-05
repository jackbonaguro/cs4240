package com.tiger.compiler.parser;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

import com.tiger.compiler.GrammarToken;
import com.tiger.compiler.Token;
import com.tiger.compiler.parser.ProductionRule;
import com.tiger.compiler.parser.Nonterminal;

public class ParsingTable {
	public HashMap<GrammarToken, HashMap<Token, Integer>> table;	
	public List<ProductionRule> productionRules;
	public String parsing_table_file = "llk_table.csv";
	public String production_rules_file = "complete_grammar.csv";

	public ParsingTable() {
		buildParsingTable(parsing_table_file);
		buildProductionRules(production_rules_file);
	}

	public boolean productionExpansionExists(GrammarToken production, GrammarToken terminal) {
		//return true if a number exists
		//return false if error 
		return false;
	}

	public int getProductionNumber(GrammarToken production, GrammarToken terminal) {
		//return the number associated with the production rule to expand
		return 0;
	}

	public Map<GrammarToken, Map<Token, Integer>> buildParsingTable(String filename) {
		Map<Token, Integer> terminal_to_production_numbers = new HashMap<>();
		Map<GrammarToken, Map<Token, Integer>> parsing_table = new HashMap<>();
		List<Token> terminals = new ArrayList<>();

		try {
			Scanner scanner = new Scanner(new File(filename));

			String tokens_row = scanner.nextLine();
			Scanner rowReader = new Scanner(tokens_row).useDelimiter(",");

			while(rowReader.hasNext()) {
				//System.out.println(rowReader.next());
				//System.out.println("JFIDLSFD" + Token.valueOf(rowReader.next()));
				terminals.add(Token.valueOf(rowReader.next()));
			}

			while(scanner.hasNext()) {

				tokens_row = scanner.nextLine();
				rowReader = new Scanner(tokens_row).useDelimiter(",");

				GrammarToken production = Nonterminal.valueOf(rowReader.next());

				//System.out.println("Production:" + production);
				//System.out.println("terminals:" + terminals);




				for(Token terminal : terminals) {
					String productionNumString = rowReader.next();
					int transitionNumber;
					if(productionNumString.equals("E") || productionNumString.equals("E ")) {
						transitionNumber = -1;
					} else {
						transitionNumber = Integer.parseInt(productionNumString);
					}

					terminal_to_production_numbers.put(terminal, transitionNumber);
				}

				parsing_table.put(production, terminal_to_production_numbers);
				//System.out.println("Map Production to another map" + parsing_table.get(production));
			}
		} catch(Exception e) {
			System.out.println(e);
		}

		return parsing_table;

	}

	public Map<Integer, ProductionRule> buildProductionRules(String filename) {
		Map<Integer, ProductionRule> production_rules = new HashMap<>();
		List<GrammarToken> right_hand_tokens;

		try {
			Scanner scanner = new Scanner(new File(filename));

			while(scanner.hasNext()) {
				String tokens_row = scanner.nextLine();
				Scanner rowReader = new Scanner(tokens_row).useDelimiter(",");
				right_hand_tokens  = new ArrayList<>();

					
				int rule_number = rowReader.nextInt();
				String lhs = rowReader.next();
				String rhs = rowReader.next();
			

				Scanner rhsReader = new Scanner(rhs).useDelimiter(" ");
				while(rhsReader.hasNext()) {
					String grammar_symbol = rhsReader.next();

					if(grammar_symbol.charAt(0) == '<') {
						Nonterminal y = Nonterminal.valueOf(grammar_symbol.substring(1, grammar_symbol.length() - 1));
						right_hand_tokens.add(y);
					} else if(grammar_symbol.charAt(0) == '#') {
						int i = 0;
					} else {
						Token x = Token.valueOf(grammar_symbol);
						right_hand_tokens.add(x);
					}
				}

				ProductionRule production = new ProductionRule(rule_number, Nonterminal.valueOf(lhs), right_hand_tokens);
				production_rules.put(rule_number, production);
			}
		} catch(Exception e) {
			System.out.println(e);
		}

		return production_rules;
	}


}