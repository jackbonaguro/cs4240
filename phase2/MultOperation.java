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
		result += allocation.generateLoad(op1, 0) + "\n";
		result += allocation.generateLoad(op2, 1) + "\n";
		result += "mult $t0, $t1\n";
		result += "addi $t2, $lo, 0\n";
		result += allocation.generateStore(t, 2) + "\n";
		return result;
	}
}