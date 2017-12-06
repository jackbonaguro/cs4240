import java.util.ArrayList;

public class CallrOperation implements IROperation {
	String func;
	String retVal;
	ArrayList<String> inputs; 
	public CallrOperation(String retVal, String func, ArrayList<String> inputs) {
		this.func = func;
		this.retVal = retVal;
		this.inputs = inputs;
	}
}