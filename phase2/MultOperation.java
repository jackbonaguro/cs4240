public class MultOperation implements IROperation {
	String op1;
	String op2;
	String t;
	public MultOperation(String op1, String op2, String t) {
		this.op1 = op1;
		this.op2 = op2;
		this.t = t;
	}

	public String generate(Allocation allocation) {
		String result = "";
		result += allocation.generateLoad(op1, 0);
		result += allocation.generateLoad(op2, 1);
		result += "mult $t0, $t1";
		result += "addi $t2, $lo, 0";
		result += allocation.generateStore(t, 2);
		return result;
	}
}