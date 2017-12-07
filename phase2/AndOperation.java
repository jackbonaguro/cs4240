public class AndOperation implements IROperation {
	String op1;
	String op2;
	String t;
	public AndOperation(String op1, String op2, String t) {
		this.op1 = op1;
		this.op2 = op2;
		this.t = t;
	}
	
	public String generate(Allocation allocation) {
		String result = "";
		result += allocation.generateLoad(op1, 1);
		result += "";
		result += allocation.generateLoad(op2, 2);
		result += "and $t0, $t1, $t2";
		result += allocation.generateStore(t, 0);
		/*result += allocation.generateLoad(op1, 0);
		result += allocation.generateLoad(op2, 1);
		result += "";
		result += allocation.generateStore(t, 2);*/
		return result;
	}
}