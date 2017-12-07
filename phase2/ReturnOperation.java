public class ReturnOperation implements IROperation {
	String x;
	public ReturnOperation(String x) {
		this.x =x; 
	}
	
	public String generate(Allocation allocation) {
		String result = "";
		result += allocation.generateLoad(x, 0);
		result += "return $t0";
		return result;
	}
}