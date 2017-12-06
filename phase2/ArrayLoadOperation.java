public class ArrayLoadOperation implements IROperation {
	String arrName;
	String offset;
	String x;
	public ArrayLoadOperation(String arrName, String offset, String x) {
		this.arrName = arrName;
		this.offset = offset;
		this.x = x;
	}
}