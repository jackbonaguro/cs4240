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
		String result = "";
		/*result += allocation.generateLoad(op1, 0);
		result += allocation.generateLoad(op2, 1);
		result += "";
		result += allocation.generateStore(t, 2);*/
		return result;
	}
}