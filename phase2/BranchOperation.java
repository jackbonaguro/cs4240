public class BranchOperation implements IROperation {
	String cond;
	String y;
	String z;
	String label;
	public BranchOperation(String cond, String y, String z, String label) {
		this.cond = cond;
		this.y = y;
		this.z = z;
		this.label = label;
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
		return "Branch: b"+cond+", "+y+", "+z+", "+label;
	}
}