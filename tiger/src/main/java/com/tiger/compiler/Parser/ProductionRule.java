package com.tiger.compiler.parser;

import java.util.List;

import com.tiger.compiler.GrammarToken;
import com.tiger.compiler.parser.Nonterminal;

public class ProductionRule {
	private int rule_number;
	private Nonterminal lhs;
	private List<GrammarToken> rhs;

	public ProductionRule(int rule_number, Nonterminal lhs, List<GrammarToken> rhs) {
		this.rule_number = rule_number;
		this.lhs = lhs;
		this.rhs = rhs;
	}
}