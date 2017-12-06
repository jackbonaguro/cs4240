public class LabelOperation implements IROperation {
	public String name;

	public LabelOperation(String name) {
		this.name = name;
	}
	
	public String generate(Allocation allocation) {
		String result = "";
		/*result += allocation.generateLoad(op1, 0);
		result += allocation.generateLoad(op2, 1);
		result += "";
		result += allocation.generateStore(t, 2);*/
		return result;
	}

	public String toString() {
		return "Label: "+name;
	}
}