import java.util.ArrayList;

public class CallOperation implements IROperation {
	String func;
	ArrayList<String> inputs; 
	public CallOperation(String func, ArrayList<String> inputs) {
		this.func = func;
		this.inputs = inputs;
	}
}