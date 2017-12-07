public class GotoOperation implements IROperation {
	String label;
	public GotoOperation(String label) {
		this.label = label;
	}
	
	public String generate(Allocation allocation) {
		String result = "#goto\n";
		result += "j "+ allocation.generateLabel(label) + "\n";
		return result;
	}
}