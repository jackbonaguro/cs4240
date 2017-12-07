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
		String result = "#array_load\n";
		result += allocation.generateAddress(arrName, 0) + "\n";
		result += allocation.generateLoad(offset, 1) + "\n";
		result += "addi $t2, $0, 4\n";
		result += "mult $t1, $t2\n"; //Multiply offset by 4 for word-alignment
		result += "mflo $t3\n";
		result += "add $t4, $t0, $t3\n";
		result += "lw $t5, 0($t4)\n";
		result += allocation.generateStore(x, 5) + "\n";
		return result;
	}
}