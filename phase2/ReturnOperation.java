public class ReturnOperation implements IROperation {
	String x;
	public ReturnOperation(String x) {
		this.x =x; 
	}
	
	public String generate(Allocation allocation) {
		String result = "";
		/*result += allocation.generateLoad(op1, 0);
		result += allocation.generateLoad(op2, 1);
		result += "";
		result += allocation.generateStore(t, 2);*/
		return result;
	}
}