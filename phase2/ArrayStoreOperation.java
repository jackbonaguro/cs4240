public class ArrayStoreOperation implements IROperation {
	String arrName;
	String offset;
	String x;
	public ArrayStoreOperation(String arrName, String offset, String x) {
		this.arrName = arrName;
		this.offset = offset;
		this.x = x;
	}
}