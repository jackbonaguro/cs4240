package com.tiger.compiler;

import java.io.*;
import java.util.Scanner;


import com.tiger.compiler.parser.TigerParser;
import com.tiger.compiler.scanner.TigerScanner;

import com.tiger.compiler.parser.ParseTreeNode;
import com.tiger.compiler.scanner.DfaState;
import static com.tiger.compiler.Token.*;
import java.util.*;


public class Comp {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello world!");

        String filepath = args[0];
        //String dfa_excel = args[1];
        TigerScanner scanner = new TigerScanner(filepath);
        TigerParser parser = new TigerParser(scanner);
        parser.parse();

		// DfaState state = new DfaState(1);
		
        // demoTree();
    }

    public static void demoTree() {
    	Token token = Token.COMMA;
		ParseTreeNode node = new ParseTreeNode(token);

		ArrayList<ParseTreeNode> children = new ArrayList<ParseTreeNode>();
		ParseTreeNode child1, child2, child3;
		child1 = new ParseTreeNode(token, node);
		child2 = new ParseTreeNode(token, node);
		child3 = new ParseTreeNode(token, node);
		children.add(child1);
		children.add(child2);
		children.add(child3);
		node.children = children;

		ArrayList<ParseTreeNode> grandChildren1 = new ArrayList<ParseTreeNode>();
		ParseTreeNode gchild1;
		gchild1 = new ParseTreeNode(token, child1);
		grandChildren1.add(gchild1);
		child1.children = grandChildren1;

		ArrayList<ParseTreeNode> grandChildren2 = new ArrayList<ParseTreeNode>();
		ParseTreeNode gchild2, gchild3;
		gchild2 = new ParseTreeNode(token, child2);
		gchild3 = new ParseTreeNode(token, child2);
		grandChildren2.add(gchild2);
		grandChildren2.add(gchild3);
		child2.children = grandChildren2;

		System.out.println("THIS IS THE TREE (in right->left order)");
		printTree(node);
    }


    public static void printTree(ParseTreeNode root) {
    	Stack<ParseTreeNode> stack = new Stack<ParseTreeNode>();
    	Stack<ParseTreeNode> newStack = new Stack<ParseTreeNode>();

    	stack.push(root);
    	recurseTree(stack, newStack);
    }

    public static void recurseTree(Stack<ParseTreeNode> stack, Stack<ParseTreeNode> newStack) {
    	// System.out.println("CURRENT STACK SIZE:\t" + stack.size());

		// populate new stack
		for (ParseTreeNode current : stack) {
    		for (ParseTreeNode child : current.children) {
			    newStack.push(child);
		    }
    	}
			
		// System.out.println("CURRENT NEWSTACK SIZE:\t" + newStack.size());
		ParseTreeNode current;
		ParseTreeNode parent;
		System.out.print("(");

		current = stack.pop();
        parent = current.parent;
   //      do {
			// // print good stuff
			// if (current.parent == null) { // root
			// 	System.out.print("ROOT: " + current.grammarToken);

			// } else {
			// 	if (current.parent == parent) {
			// 		System.out.print(" " + current.grammarToken);

			// 	} else {
			// 		parent = current.parent;
			// 		System.out.print(" )( " + current.grammarToken);
			// 	}
			// }
			// current = stack.pop();
   //      } while (!stack.empty());

        // make method

        String line = "";
        String printLine = stringifyTree(stack, current, parent, line);
        System.out.print(printLine);


        System.out.println(" )");

   		populate(stack, newStack);

    	if (!stack.empty()) {
    		recurseTree(stack, newStack);
    	}
    }

    public static String stringifyTree(Stack<ParseTreeNode> stack, ParseTreeNode current, ParseTreeNode parent, String line) {
    	// print good stuff
		if (current.parent == null) { // root
			line = "ROOT: " + current.grammarToken;

		} else {
			if (current.parent == parent) {
				line  = line + (" " + current.grammarToken);

			} else {
				parent = current.parent;
				line = line + (" )( " + current.grammarToken);
			}
		}
		if (!stack.empty()) {
			current = stack.pop();
			return stringifyTree(stack, current, parent, line);
		}
		return line;
    }

    public static Stack<ParseTreeNode> populate(Stack<ParseTreeNode> stack, Stack<ParseTreeNode> newStack) {
    	// System.out.println("HERE ARE THE children:");
    	// for (ParseTreeNode child: newStack) {
    	// 	System.out.print(child.grammarToken);
    	// }
    	if (newStack.empty()) {
    		return stack;
    	}
    	stack.push(newStack.pop());
    	return populate(stack, newStack);
    
    }


	// public static void oldMain(String[] args) throws IOException {
	// 	String filepath = args[0];

	// 	Scanner sc = new Scanner(new File(filepath));
	// 	sc.useDelimiter("");

	// 	String current = "";
	// 	Token prev = new Token("",null);
	// 	String c = "";
	// 	boolean proceed = true;
	// 	boolean substring = false;

	// 	while(sc.hasNext()) {

	// 		if (proceed) {
	// 			c = sc.next();
	// 		}

			
	// 		TokenType tt = null;

	// 		//System.out.println("'" + c + "'");
	// 		if (c.equals("\n") || c.equals("\t") || c.equals(" ")) {
	// 			continue;
	// 		}

	// 		prev.setName(current);
	// 		current = current + c;

	// 		System.out.println("C: " + c);
	// 		System.out.println("Current: " + current);

	// 		substring = false;	//We can discard current if it won't lead to a
	// 							//valid token
	// 		for (TokenType type: TokenType.values()) {
	// 			//System.out.print(type.label);
	// 			//System.out.print(", ");
	// 			//System.out.print(current);
	// 			if (type.label.equals(current)) {
	// 				tt = TokenType.valueOf(type.name());
	// 				//System.out.println(tt.getClass());
	// 			} else if (current.length() < type.label.length() && current
	// 				.equals(type.label.substring(0,current.length()))) {
	// 				substring = true;
	// 			}
	// 		}
	// 		if (tt == null) {
	// 			//Now check for id/literal types
	// 		}

	// 		//If tt is still null, then prev was the longest token
	// 		if (tt == null && prev.getType() != null) {
	// 			// *RETURN*
	// 			System.out.println(prev);
	// 			current = "";
	// 			prev = new Token("",null);
	// 			proceed = false;
	// 		} else if (tt == null) {
	// 			if (!substring) {
	// 				//This is where you'd throw an error: No valid substring
	// 				// can be made so we reset current
	// 				System.out.println("\nError parsing symbol: "
	// 					+ prev.getName() + "");

	// 				current = "";
	// 				prev.setName("");
	// 			}
	// 			proceed = true;
	// 		} else {
	// 			proceed = true;
	// 			prev.setType(tt);
	// 		}
	// 	}
	// 	//At end of file, must return last valid token
	// 	prev.setName(prev.getName() + c);
	// 	for (TokenType type: TokenType.values()) {
	// 		if (type.label.equals(prev.getName())) {
	// 				prev.setType(TokenType.valueOf(type.name()));
	// 		}	//No need to check for substring, it won't lead to valid token
	// 	}
	// 	if (prev.getType() == null) {
	// 		//Now check for id/literal types
	// 	}
	// 	System.out.println(prev);
	// }
}