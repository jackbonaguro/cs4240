import java.util.ArrayList;

public class FloatListOperation implements IROperation {
	public ArrayList<String> floats;

	public FloatListOperation(ArrayList<String> floats) {
		this.floats = floats;
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