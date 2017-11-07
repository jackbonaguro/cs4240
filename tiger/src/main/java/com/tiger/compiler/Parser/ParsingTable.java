package com.tiger.compiler.parser;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

import com.tiger.compiler.parser.GrammarToken;
import com.tiger.compiler.Token;
import com.tiger.compiler.parser.ProductionRule;
import com.tiger.compiler.parser.Nonterminal;
import com.tiger.compiler.parser.SemanticAction;

public class ParsingTable {
	public HashMap<Nonterminal, HashMap<Token, Integer>> table;
	public Map<Integer, ProductionRule> rule_lookup;
	public String parsing_table_file = "llk_table.csv";
	public String production_rules_file = "complete_grammar.csv";

	public ParsingTable() {
		this.table = buildParsingTable(parsing_table_file);
		this.rule_lookup = buildProductionRules(production_rules_file);
	}

	public boolean productionExpansionExists(Nonterminal production, GrammarToken terminal) {
		Map<Token, Integer> row = this.table.get(production);
		int rule_number = row.get(terminal);
		return rule_number != (-1);
	}

	public int getProductionNumber(GrammarToken production, GrammarToken terminal) {
		//return the number associated with the production rule to expand
		Map<Token, Integer> row = this.table.get(production);
		int rule_number = row.get(terminal);
		return rule_number;
	}

	public ProductionRule getProduction(GrammarToken production, GrammarToken terminal) {
		Map<Token, Integer> row = this.table.get(production);
		int rule_number = row.get(terminal);
		ProductionRule prod = rule_lookup.get(rule_number);
		return prod;
	}

	public HashMap<Nonterminal, HashMap<Token, Integer>> buildParsingTable(String filename) {
		HashMap<Nonterminal, HashMap<Token, Integer>> parsing_table = new HashMap<>();
		List<Token> terminals = new ArrayList<>();
		Scanner scanner = null;

		try {
			scanner = new Scanner(new File(filename));

		} catch(Exception e) {
			System.out.println(e);
		}


		String tokens_row = scanner.nextLine();
		Scanner rowReader = new Scanner(tokens_row).useDelimiter(",");
		
		while(rowReader.hasNext()) {
			//System.out.println(rowReader.next());
			//System.out.println("JFIDLSFD" + Token.valueOf(rowReader.next()));
			terminals.add(Token.valueOf(rowReader.next()));
		}

		while(scanner.hasNext()) {
			HashMap<Token, Integer> terminal_to_production_numbers = new HashMap<Token, Integer>();
			
			tokens_row = scanner.nextLine();
			rowReader = new Scanner(tokens_row).useDelimiter(",");

			Nonterminal production = Nonterminal.valueOf(rowReader.next());

			//System.out.println("Production:" + production);
			//System.out.println("terminals:" + terminals);


			//System.out.println(tokens_row);
			//System.out.println(terminals);

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
			// System.out.println("buildParsingTable");
			//System.out.println(production);
			//System.out.println(terminal_to_production_numbers);
			parsing_table.put(production, terminal_to_production_numbers);
			
		}


		rowReader.close();
		scanner.close();
		

		//System.out.println(parsing_table.get(Nonterminal.TIGER_PROGRAM));
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
						//System.out.println("Nonterminal matching:" + grammar_symbol);
						Nonterminal y = Nonterminal.valueOf(grammar_symbol.substring(1, grammar_symbol.length() - 1));
						right_hand_tokens.add(y);
					} else if(grammar_symbol.charAt(0) == '#') {
						//Semantic Actions
						SemanticAction z = SemanticAction.valueOf(grammar_symbol.substring(1, grammar_symbol.length() - 1));
						//int i = 0;
						right_hand_tokens.add(z);
					} else {
						Token x = Token.valueOf(grammar_symbol);
						right_hand_tokens.add(x);
					}
				}

				ProductionRule production = new ProductionRule(rule_number, Nonterminal.valueOf(lhs), right_hand_tokens);
				production_rules.put(rule_number, production);
			}
		} catch(Exception e) {
			System.out.println("buildProductionRules");
			System.out.println(e);
		}

		return production_rules;
	}


}