public class ArrayLoadOperation implements IROperation {
	String arrName;
	String offset;
	String x;
	public ArrayLoadOperation(String x, String arrName, String offset) {
		this.arrName = arrName;
		this.offset = offset;
		this.x = x;
	}

	public String generate(Allocation allocation) {
		String result = "";
		result += allocation.generateAddress(arrName, 0) + "\n";
		result += allocation.generateLoad(offset, 1) + "\n";
		result += "add $t2, $t0, $t1\n";
		result += "lw $t3, 0($t2)\n";
		result += allocation.generateStore(x, 3) + "\n";
		return result;
	}
}