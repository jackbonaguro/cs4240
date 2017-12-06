public class CallOperation implements IROperation {
	String func;
	ArrayList<String> inputs; 
	public BrneqOperation(String func, ArrayList<String> inputs) {
		this.func = func;
		this.inputs = inputs;
	}
}