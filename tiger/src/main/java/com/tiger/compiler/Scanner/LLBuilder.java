package com.tiger.compiler.scanner;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import java.io.File;

import com.tiger.compiler.scanner.DfaState;
import com.tiger.compiler.scanner.CharCat;

import com.tiger.compiler.TokenTuple;
import com.tiger.compiler.scanner.Productions;


public class LLBuilder {
    public String FILENAME = ("ll_table.csv");

    public LLBuilder() {
       // refactor this
    }

    public List<TableState> LLTable() {
        List<LLState> graph = new ArrayList<>();
        List<LLState> states = new ArrayList<>();
        List<TokenTuple> tokenTuples;

        
 
        
    }

}
