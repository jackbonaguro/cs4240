/**
 * The identifier table. Currently uses universal scope variable. In the future may use linked tables
 * to handle to scope.
 * Creates entries. To use scope, initialize, add entries with putEntry(). On entry and exit of scopes,
 * use initializeScope() and finalizeScope(), respectively
 */

package com.tiger.compiler;

import java.util.*;
import com.tiger.compiler.IdentifierTableEntry;

public class IdentifierTable {
    private HashMap<Integer,IdentifierTableEntry> table;
    private IdentifierTable next = null;
    private int scope;

    public IdentifierTable() {
        this.table = new HashMap<Integer, IdentifierTableEntry>();
        this.next = null;
        this.scope = 0;
    }

    // used to point to surrounding scope table
    public void setNext(IdentifierTable next) {
        this.next = next;
    }

    public IdentifierTableEntry lookup(int id) {
        return table.get(id);
    }

    public void putEntry(int id, String entryName, int entryTypeId, int entryScope) {
        IdentifierTableEntry newEntry = new IdentifierTableEntry(entryName, entryTypeId, entryScope);
        table.put(id, newEntry);
    }

    public void initializeScope() {
        scope += 1;
    }

    public void finalizeScope() {
        if (scope <= 0) {
            return;
        }
        scope -= 1;
        for (Object key : table.keySet()) {
            if (table.get(key).scope >= scope) {
                table.remove(key);
            }
        }
    }
}
