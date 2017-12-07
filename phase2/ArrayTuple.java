public class ArrayTuple {
	public String name;
	public int size;

	public ArrayTuple(String name, int size) {
		this.name = name;
		this.size = size;
	}

	public String toString() {
		return "Array["+name+","+size+"]";
	}
}