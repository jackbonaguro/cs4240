package com.tiger.compiler.parser;

import java.util.ArrayList;
import com.tiger.compiler.parser.GrammarToken;

public class ParseTreeNode {
	public ParseTreeNode parent;
	public ArrayList<ParseTreeNode> children;

	public GrammarToken grammarToken;

	public ParseTreeNode(GrammarToken gt, ParseTreeNode p) {
		this.grammarToken = gt;
		this.parent = p;
		this.children = new ArrayList<ParseTreeNode>();
	}
}