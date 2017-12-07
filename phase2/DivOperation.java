public class DivOperation implements IROperation {
	String op1;
	String op2;
	String t;
	public DivOperation(String op1, String op2, String t) {
		this.op1 = op1;
		this.op2 = op2;
		this.t = t;
	}
	
	public String generate(Allocation allocation) {
		String result = "#div\n";
		result += allocation.generateLoad(op1, 1) + "\n";
		result += allocation.generateLoad(op2, 2) + "\n";
		result += "div $t1, $t2" + "\n";
		result += "mflo $t0\n";
		result += allocation.generateStore(t, 0) + "\n";
		return result;
	}
}