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
	
	// b	target		#  unconditional branch to program label target
	// beq	$t0,$t1,target	#  branch to target if  $t0 = $t1
	// blt	$t0,$t1,target	#  branch to target if  $t0 < $t1
	// ble	$t0,$t1,target	#  branch to target if  $t0 <= $t1
	// bgt	$t0,$t1,target	#  branch to target if  $t0 > $t1
	// bge	$t0,$t1,target	#  branch to target if  $t0 >= $t1
	// bne	$t0,$t1,target	#  branch to target if  $t0 <> $t1

	public String generate(Allocation allocation) {
		String result = "#branch\n";
		result += allocation.generateLoad(y, 0) + "\n";
		result += allocation.generateLoad(z, 1) + "\n";
		result += "b"+cond+"\t$t0, $t1, "+allocation.generateLabel(label) + "\n";
		return result;
	}

	public String toString() {
		return "Branch: b"+cond+", "+y+", "+z+", "+label;
	}
}