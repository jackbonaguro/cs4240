package com.tiger.compiler;

public class IdentifierTableEntry extends Object{
    public String name;
    public int id;
    public int typeId;
    public int scope;

    public IdentifierTableEntry(int id, String name, int typeId, int scope) {
    	this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.scope = scope;
    }
}
