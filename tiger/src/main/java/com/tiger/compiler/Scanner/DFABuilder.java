package com.tiger.compiler.scanner;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import java.net.URL;
import java.io.File;

import com.tiger.compiler.scanner.DfaState;
import com.tiger.compiler.scanner.CharCat;


public class DFABuilder {
    public String FILENAME;
    public URL url = DFABuilder.class.getResource("/dfa_table.csv");

    public DFABuilder(String dfa_excel) {
        this.FILENAME = dfa_excel;
    }

    public List<DfaState> buildDFA() {
        List<DfaState> graph = new ArrayList<>();
        List<DfaState> states = new ArrayList<>();
        List<CharCat> characters;
        //System.out.println(url.getFile());
        try {
            Scanner scanner = new Scanner(new File(FILENAME));
            //scanner.useDelimiter(",");
            
            //get first line of csv, all the Character categories
            String firstRow = scanner.nextLine();
            Scanner rowReader = new Scanner(firstRow).useDelimiter(",");
            characters = new ArrayList<>();
            rowReader.next(); // not sure why I need to do this
            while(rowReader.hasNext()) {
                String columnCategory = rowReader.next();
                //System.out.println("columnCategory:" + columnCategory);
                characters.add(CharCat.valueOf(columnCategory));
                //System.out.println("Characters: " + characters.toString());
            }

            int num_dfa_state = 0;
            while(scanner.hasNext()) {
                String state = scanner.nextLine();
                states.add(new DfaState(num_dfa_state++));
            }

            System.out.println("states:" + states.toString());


            scanner.close();

        } catch(FileNotFoundException e) {
            System.out.println("Could not find " + FILENAME + ".");
        }






        return graph;
    }

}
