public class ArrayAssignOperation implements IROperation {
	String op1;
	String op2;
	String op3;

	public ArrayAssignOperation(String op1, String op2, String op3) {
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
	}

	public String generate(Allocation allocation) {
		String result = "";
		result += op1+":\t.word\t";

		int size = 0;
		try {
			size = Integer.parseInt(op1);
		} catch (Exception e) {
			return "";
		}
		for (int i = 0; i < size; i++) {
			if (i == size - 1) {
				result += op3;
			} else {
				result += op3+", ";
			}
		}
		return result;
	}
}