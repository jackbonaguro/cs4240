package com.tiger.compiler.parser;

import java.util.*;

public class TypeTableEntry extends Object{
	public String name;
	public int parent;
	public boolean isAlias;

	public TypeTableEntry(String name) {
		this.name = name;
		this.parent = 0;
		this.isAlias = false;
	}
}