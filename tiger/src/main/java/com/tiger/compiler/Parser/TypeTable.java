package com.tiger.compiler.parser;

import java.util.*;
import com.tiger.compiler.TypeTableEntry;

public class TypeTable {
  HashMap<Integer,TypeTableEntry> table;

  public TypeTable() {
  	this.table = new HashMap<Integer,TypeTableEntry>();
  }

  public void putEntry(int hash, TypeTableEntry entry) {

  	for (TypeTableEntry ent : table.getValues()) {
  	    
  		if (ent.name.equals(entry.name)) {
  			System.out.println("Cain't do dat");
  			return;
  		}
  	}
  	this.table.put(hash, entry);
  }

  public void readEntries() {
  	for (Integer hash : table.keySet()) {
            TypeTableEntry ent = table.get(hash);
            System.out.print(hash + " : " + ent.id + ", ");
            System.out.println(ent.name);
        }

  }
}