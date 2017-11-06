/*
* Linked list of IdentifierTable objects. After using finalize() or initialize(), be sure to update your
* table variable to point to the current with getCurrent().
*/

package com.tiger.compiler;

public class IdentifierTableList {

    private IdentifierTable current;
    private int scope;

    public IdentifierTableList() {
        this.current = new IdentifierTable();
        this.scope = 0;
    }
-
    public IdentifierTable getCurrent() {
        return this.current;
    }

    public void initializeScope() {
        IdentifierTable higherTable = new IdentifierTable();
        higherTable.setNext(this.current);
        this.current = higherTable;

        this.scope += 1;
        this.current.setScope(this.scope);

    }

    public void finalizeScope() {
        if (scope <= 0) {
            System.out.println("Yep, done goofed");
            return;
        }
        this.scope -= 1;
        this.current = current.getNext();
    }


}
