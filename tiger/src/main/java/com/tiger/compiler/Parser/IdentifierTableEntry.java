package com.tiger.compiler;

public class IdentifierTableEntry {
    public String name= "";
    public int typeId = 0;
    public int scope = 0;

    public IdentifierTableEntry(String name, int typeId, int scope) {
        this.name = name;
        this.typeId = typeId;
        this.scope = scope;
    }
}
