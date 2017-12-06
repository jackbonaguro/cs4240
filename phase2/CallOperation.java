import java.util.ArrayList;

public class CallOperation implements IROperation {
	String func;
	ArrayList<String> inputs; 
	public CallOperation(String func, ArrayList<String> inputs) {
		this.func = func;
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
		return "Call: "+func+", "+inputs;
	}
}