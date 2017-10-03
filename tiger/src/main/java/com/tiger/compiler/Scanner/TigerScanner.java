package com.tiger.compiler.scanner;

import com.tiger.compiler.Token;
import com.tiger.compiler.scanner.DFABuilder;
import com.tiger.compiler.scanner.CharCat;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TigerScanner {

	private List<DfaState> transitions;
	private DFABuilder builder;
	private List<Character> charStream;

	//because we need character stream we use a file reader
	private FileReader filereader;
	private int currentState;

	public TigerScanner(String filename, String dfa_excel) {
		System.out.println("TigerScanner constructor");
		this.builder = new DFABuilder(dfa_excel);
		this.transitions = this.builder.buildDFA();
		this.charStream = new ArrayList<>();

		this.currentState = 0;

		try {
			this.filereader = new FileReader(new File(filename));
			int c;
			while((c = filereader.read()) != -1) {
				char character = (char) c;
				
				charStream.add(character);
			}

			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Tiger scanner could not find the file.");
		} catch (NullPointerException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	public Token next() throws RuntimeException {
		
		System.out.println("This is the scanner next method.");
		return null;


	}
}