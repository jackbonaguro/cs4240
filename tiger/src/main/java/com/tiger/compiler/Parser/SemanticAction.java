package com.tiger.compiler.parser;

import com.tiger.compiler.parser.GrammarToken;

public enum SemanticAction implements GrammarToken{
	IDSTACK_PUSH_ID, IDSTACK_PUSH_TYPE, IDSTACK_PUSH_CONST, IDSTACK_POP_TYPE 
}