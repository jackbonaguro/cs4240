package com.tiger.compiler.scanner;

import com.tiger.compiler.Token;
import com.tiger.compiler.TokenTuple;
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

	public TokenTuple next() throws RuntimeException {

		//System.out.println("TRANSITIONS: " + this.transitions.toString());

		String currentString = "";
		DfaState curr_state = transitions.get(0);
		DfaState last_final;
		int input_pos_last_final = 0;
		int curr_pos = 0;
		
		//System.out.println("This is the scanner next method.");

		System.out.println(this.charStream.toString());

		while(!curr_state.isErrorState()) {
			char character = this.charStream.get(curr_pos++);
			currentString += character;
			CharCat category = CharCat.classOf(character);
			//System.out.println("currentString:" + currentString);
			System.out.println("category:" + category.toString());
			System.out.println("curr_state:" + curr_state.next(category).toString());
			curr_state = curr_state.next(category);
		}



		return null;

	}
}