public class GotoOperation implements IROperation {
	String op1;
	public GotoOperation(String op1) {
		this.op1 = op1;
	}
	
	public String generate(Allocation allocation) {
		String result = "";
		/*result += allocation.generateLoad(op1, 0);
		result += allocation.generateLoad(op2, 1);
		result += "";
		result += allocation.generateStore(t, 2);*/
		return result;
	}
}