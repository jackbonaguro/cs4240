package com.tiger.compiler.scanner;

import com.tiger.compiler.Token;
import com.tiger.compiler.scanner.DFABuilder;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.FileNotFoundException;

public class TigerScanner {

	private List<DfaState> transitions;
	private DFABuilder builder;

	//private TigerScannerDFA dfa;
	private Scanner sc;
	int currentState;

	public TigerScanner(String filename, String dfa_excel) {
		//this.dfa = new TigerScannerDFA();
		System.out.println("FIle name:" + filename);
		try {
			this.sc = new Scanner(new File(filename));
			this.sc.useDelimiter("");
		} catch (FileNotFoundException e) {
			System.out.println("Tiger scanner could not find the file.");
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		this.builder = new DFABuilder(dfa_excel);
		this.transitions = this.builder.buildDFA();

		this.currentState = 0;
	}

	public Token next() throws RuntimeException {
		if(sc.hasNext()) {
			String c = sc.next();
		}
		//Token t = new Token();
		System.out.println("This is the scanner next method.");
		return null;
	}
}