public class ReturnOperation implements IROperation {
	String x;
	public ReturnOperation() {
	}
	
	public String generate(Allocation allocation) {
		String result = "";
		result += "return $ra";
		return result;
	}
}