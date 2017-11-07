package com.tiger.compiler.parser;

public class IdentifierTableEntry extends Object{
    public String name;
    public int typeId;
    public int scope;

    public IdentifierTableEntry(String name, int typeId, int scope) {
        this.name = name;
        this.typeId = typeId;
        this.scope = scope;
    }
}
