public class ReturnOperation implements IROperation {
	String x;
	public ReturnOperation() {
	}
	
	public String generate(Allocation allocation) {
		String result = "";
		result += "return $ra" + "\n";
		return result;
	}
}