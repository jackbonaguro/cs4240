public class AssignOperation implements IROperation {
	public String op1;
	public String op2;

	public AssignOperation(String op1, String op2) {
		this.op1 = op1;
		this.op2 = op2;
	}

	public String generate(Allocation allocation) {
		String result = "";
		result += op1+":\t.word\t"+op2;
		return result;
	}
}