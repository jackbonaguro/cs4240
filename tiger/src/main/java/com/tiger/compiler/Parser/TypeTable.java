package com.tiger.compiler.parser;

import java.util.*;
import com.tiger.compiler.parser.TypeTableEntry;

public class TypeTable {
  public HashMap<Integer,TypeTableEntry> table;

  public TypeTable() {
  	this.table = new HashMap<Integer,TypeTableEntry>();

    //Native types
    TypeTableEntry intEntry = new TypeTableEntry("int");
    try {
      this.putEntry(intEntry.hashCode(), intEntry);
    } catch (Exception e) {

    }
    TypeTableEntry floatEntry = new TypeTableEntry("float");
    try {
      this.putEntry(floatEntry.hashCode(), floatEntry);
    } catch (Exception e) {

    }
  }

  public void putEntry(int hash, TypeTableEntry entry) throws Exception{
  	for (TypeTableEntry ent : table.values()) {
  	    
  		if (ent.name.equals(entry.name)) {
  			throw new Exception("Semantic Error");
  		}
  	}
  	this.table.put(hash, entry);
  }

  public void readEntries() {
  	for (Integer hash : table.keySet()) {
            TypeTableEntry ent = table.get(hash);
            System.out.print(hash + " : " + ent.name + ", ");
            System.out.println(ent.name);
        }

  }

  public int getParent(int entryHash) {
  	return table.get(entryHash).parent;
  }
}