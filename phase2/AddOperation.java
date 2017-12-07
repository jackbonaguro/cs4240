public class AddOperation implements IROperation {
	String op1;
	String op2;
	String t;
	public AddOperation(String op1, String op2, String t) {
		this.op1 = op1;
		this.op2 = op2;
		this.t = t;
	}

	public String generate(Allocation allocation) {
		String result = "#add\n";
		result += allocation.generateLoad(op1, 1) + "\n";
		result += "";
		result += allocation.generateLoad(op2, 2) + "\n";
		result += "add $t0, $t1, $t2" + "\n";
		result += allocation.generateStore(t, 0) + "\n";
		return result;
	}
}