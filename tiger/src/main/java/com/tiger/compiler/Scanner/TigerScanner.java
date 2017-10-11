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
	private int line;
	private int column;
	private int curr_pos;

	public TigerScanner(String filename, String dfa_excel) {
		System.out.println("TigerScanner constructor");
		this.builder = new DFABuilder(dfa_excel);
		this.transitions = this.builder.buildDFA();
		this.charStream = new ArrayList<>();
		this.line = 1;
		this.column = 0;
		this.curr_pos = 0;

		this.currentState = 0;

		try {
			this.filereader = new FileReader(new File(filename));
			int c;
			while((c = filereader.read()) != -1) {
				char character = (char) c;
				
				charStream.add(character);
			}

			charStream.add('\0');

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


		String currentString = "";
		DfaState curr_state = transitions.get(0);
		DfaState last_state = transitions.get(0);
		int input_pos_last_final = 0;
		
		
		//System.out.println(this.charStream.toString());

		while(!curr_state.isErrorState()) {
			if(this.charStream.get(curr_pos) == '\0') {
			    return new TokenTuple("EOF", Token.EOF); 
			}

			char character = this.charStream.get(curr_pos++);
			if(character == '\n') {
				this.line++;			
			}

			currentString += character;
			System.out.println("curr_pos:" + (curr_pos-1) + "\tcurrentString:" + currentString);
			CharCat category = CharCat.classOf(character);
			column++;
			

			System.out.println("category:" + category.toString() + "\tcurr_state:" + curr_state.toString());
			// System.out.println("currentString:" + currentString);
			// System.out.println("curr_state:" + curr_state.next(category).toString());
			
			last_state = curr_state;
			curr_state = curr_state.next(category);
		}

		//at this point, we have a valid token one character previous
		column--;
		curr_pos--;

		String validString = currentString.substring(0, currentString.length() - 1);
		char delete = currentString.charAt(currentString.length() - 1); 

		System.out.println("validString: " + validString + "\ndelete: " + delete);

		//what token do we have now?
		Token token = Token.classOf(last_state, validString);

		//we can either have a valid token, whitespace, a comment, or the dfa is not a final state!
		if(token == Token.WHITESPACE || token == Token.COMMENT) {
			System.out.println("Token recognized was whitespace so return next token. curr_pos:" + curr_pos);
			return next();
		} 

		if(token == Token.ERROR) {
			//throw exception, print out column, line, etc.
			//curr_pos++; //skip the deleted character
			return next();
		}

		TokenTuple return_token = new TokenTuple(validString, token);
		return return_token;
	}
}
