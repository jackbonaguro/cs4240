public class AndOperation implements IROperation {
	String op1;
	String op2;
	String t;
	public AndOperation(String op1, String op2, String t) {
		this.op1 = op1;
		this.op2 = op2;
		this.t = t;
	}
}