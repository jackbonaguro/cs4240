

CS4240
Project Phase 1

Jack Bonaguro, Thomas Bright, & Sai Gundlapalli

The Tiger compiler front-end relies on two parts: the scanner and parser. The scanner performs lexical analysis and passes lexical Tokens to the parser. The parser performs semantic analysis and code generation. The parser also serves as the body of the front-end, calling an instances of the scanner, analyzers, and code generators. The analyzer used by the parser relies on a "symbol table," further explained below.

The symbol table is implemented in a split table fashion, dividing tables between identifiers and types. Firstly,  there is an IdentifierTableList object that creates a new table, an IdentifierTable. When a new scope is entered, the List creates a new Table and links it to the previous. The new scope's table becomes the "head" of the IdentifierTableList. The program using the Table will need to update its pointer to point to the current head. 	

The Identifier Table object is backed by a hashmap of int keys and IdentifierTableEntry values. The IdentifierTableEntry object stores necessary information, such as typeId and name. The IdentifierTable stores new entry objects in the hashmap by creating a hashcode of the entry and using it as the value's key. 

Types are referenced on a TypeTable, which is a hashmap that stores a TypeTableEntry and uses the TypeTableEntry's hashcode as a key.

The back-end is a monolithic implementation of a naive allocation scheme. Data structures exist for each of the Tiger IR's operations and helper functions exist for data allocation. These both serve to help produce MIPS code. All of the back-end components are stored in the same directory.

WORKING COMPONENTS

Scanner - The scanner is isolated as a component within its own package, com.tiger.compiler.scanner. It functions as an iterator, with a next() method that is called repeatedly to return a Token, and eventually returns the End-of-File token repeatedly. It is configured by a csv that encodes a DFA, with current state and character mapping to next state.

Parser - The parser is the largest component currently. Its package, com.tiger.compiler.parser, also contains the Semantic Analysis component. It uses the grammar to iteratively build up and tear down a parse stack using the LL(1) parse algorithm. It is configured by a csv that contains the production number, left side, and right side. The output will be a parse tree, defined by the ParseTreeNode class, upon which semantic actions can be performed.
Output: Every step outputs the full parse stack.

Semantic Analyzer - In its run, the parser may encounter a semantic action (prefixed with # in the grammar csv). In this case it hands over control to the Analyzer. The analyzer utilizes the current state of the parser as well and executes the semantic action as specified in a function. So far we've implemented basic declaration (adding to the symbol table [identifier table]) and assignment (basic type checking). These will depend on the parse tree, which has not yet been fully implemented.
Output: In between two newlines, the name of the current semantic action.

Naive Allocator - This allocation method relies on a limited number of available registers. Data is loaded into the registers and stored onto the stack on an instruction-by-instruction basis. The allocation scheme also takes care of the code generation. The compiler begins with a preprocessing sweep to initialize .word, .data, and .space variables, then performs the rest of the code generation in the .text space on a second sweep. 
Output: unoptimized MIPS asm code

BUILD & RUN

The front end uses the maven management tool. Follow this guide to install:
https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

To build the front end, navigate to the directory "tiger" and use the command

	mvn package

To run, navigate to the "tiger" directory (within the top-level directory) and use the command
	
	java -cp target/tiger-1.0-SNAPSHOT.jar com.tiger.compiler.Comp <testfile>

The backend is contained in the "phase2" directory. 
