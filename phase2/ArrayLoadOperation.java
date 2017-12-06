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
		result += allocation.generateAddress(arrName, 0);
		result += allocation.generateLoad(offset, 1);
		result += "add $t2, $t0, $t1";
		result += "lw $t3, 0($t2)";
		result += allocation.generateStore(x, 3);
		return result;
	}
}