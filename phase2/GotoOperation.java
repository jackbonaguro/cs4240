public class GotoOperation implements IROperation {
	String label;
	public GotoOperation(String label) {
		this.label = label;
	}
	
	public String generate(Allocation allocation) {
		String result = "";
		// result += allocation.generateLoad(label, 0);
		result += "";
		// result += "jr $t0";
		result += "j label" + "\n";
		return result;
	}
}