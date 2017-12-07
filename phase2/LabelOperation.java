public class LabelOperation implements IROperation {
	public String name;

	public LabelOperation(String name) {
		this.name = name;
	}
	
	public String generate(Allocation allocation) {
		String result = "";
		result += "#label\n";
		result += allocation.generateLabel(name) + ":\n\n";
		return result;
	}

	public String toString() {
		return "Label: "+name + "\n";
	}
}