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
}