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
	
	public String generate(Allocation allocation) {
		String result = "";
		/*result += allocation.generateLoad(op1, 0);
		result += allocation.generateLoad(op2, 1);
		result += "";
		result += allocation.generateStore(t, 2);*/
		return result;
	}

	public String toString() {
		return "Callr: "+retVal+", "+func+", "+inputs;
	}
}