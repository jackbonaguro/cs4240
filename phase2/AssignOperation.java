public class AssignOperation implements IROperation {
	public String op1;
	public String op2;

	public AssignOperation(String op1, String op2) {
		this.op1 = op1;
		this.op2 = op2;
	}

	public String generate(Allocation allocation) {
		// TODO: rework
		String result = "";
		result += allocation.generateLoad(op2, 0) + "\n";
		result += allocation.generateStore(op1, 0) + "\n";
		return result;
	}
}