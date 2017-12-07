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
		String result = "#array_assign\n";
		//load the array address
		result += allocation.generateAddress(op1, 0) + "\n";
		result += allocation.generateLoad(op3, 1) + "\n";
		
		int size = 0;
		try {
			size = Integer.parseInt(op2);
		} catch (Exception e) {
			return "";
		}
		for (int i = 0; i < size; i++) {
			//if (i == size - 1) {
			result += "sw $t1, "+ (4 * i) +"($t0)\n";	//Word-aligned
			//result += "addi $t0, $t0, 1\n";
			/*} else {
				result += op3+", ";
			}*/
		}
		return result;
	}
}