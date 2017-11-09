/**
 * The identifier table. Currently used with IdentifierTableList
 */

package com.tiger.compiler.parser;

import java.util.*;
import com.tiger.compiler.parser.IdentifierTableEntry;

public class IdentifierTable {
    private HashMap<Integer,IdentifierTableEntry> table;
    private IdentifierTable next = null;
    private int scope;

    public IdentifierTable() {
        this.table = new HashMap<Integer, IdentifierTableEntry>();
        this.next = null;
        this.scope = 0;
    }

    /* Used to point to surrounding scope table */
    public void setNext(IdentifierTable next) {
        this.next = next;
    }

    public IdentifierTable getNext() {
        return this.next;
    }

    /*
     When the list initializes table, scope is zero; inc and dec are insufficient
     */
    public void setScope(int scope) {
        this.scope = scope;
    }

    /*
    * Retrieve table entry based on id */
    public IdentifierTableEntry lookup(int id) {
        return table.get(id);
    }

    /*
    * Place entry on table */
    public void putEntry(String entryName, int entryTypeId) throws Exception{
        IdentifierTableEntry newEntry = new IdentifierTableEntry(entryName, entryTypeId, scope);
        for (IdentifierTableEntry ent : table.values()) {
            if (ent.name.equals(newEntry.name)) {
                throw new Exception("Semantic Error");
            }
        }
        table.put(newEntry.hashCode(), newEntry);
    }

    /*
    * Traverse linked list of tables and output entries
    */
    public void readEntries() {
        for (Integer key : table.keySet()) {
            IdentifierTableEntry ent = table.get(key);
            System.out.print(key + " : " + ent.typeId + ", ");
            System.out.println(ent.name + ", " + ent.scope);
        }

    }

    /*
    * Remove an entry from the table based on id */
    public void removeEntry(int id) {
        table.remove(id);
    }
}
