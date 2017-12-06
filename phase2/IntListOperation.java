import java.util.ArrayList;

public class IntListOperation implements IROperation {
	public ArrayList<String> ints;

	public IntListOperation(ArrayList<String> ints) {
		this.ints = ints;
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
		return "IntList: "+ints;
	}
}