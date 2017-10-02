package com.tiger.compiler.scanner;

import java.util.HashMap;

import com.tiger.compiler.scanner.CharCat;

public class DfaState {

	private int state;
	private HashMap<CharCat, DfaState> transitions;

	public DfaState(int stateNum) {
		this.state = stateNum;
		transitions = new HashMap<>();
	}

	public HashMap<CharCat, DfaState> addTransition(CharCat c, DfaState state) {
		transitions.put(c, state);
		return transitions;
	}

	public DfaState next(CharCat c) {
		return transitions.get(c);
	}

	public int getId() {
		return state;
	}

}
