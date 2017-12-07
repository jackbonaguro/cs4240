public class ArrayStoreOperation implements IROperation {
	String arrName;
	String offset;
	String x;
	public ArrayStoreOperation(String arrName, String offset, String x) {
		this.arrName = arrName;
		this.offset = offset;
		this.x = x;
	}
	
	public String generate(Allocation allocation) {
		String result = "#array_store\n";
		result += allocation.generateLoad(x, 0) + "\n";
		result += allocation.generateAddress(arrName, 1) + "\n";
		result += allocation.generateLoad(offset, 2) + "\n";
		result += "addi $t3, $0, 4\n";
		result += "mult $t3, $t2\n"; //Multiply offset by 4 for word-alignment
		result += "mflo $t4\n";
		result += "add $t5, $t1, $t4\n";
		result += "sw $t0, 0($t5)\n";
		return result;
	}
}