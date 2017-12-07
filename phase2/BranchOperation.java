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
		String op = cond.trim();
		String result = "";
		if (op.equals("<>")) {
			result += allocation.generateLoad(y, 1) + "\n";
			result += "";
			result += allocation.generateLoad(z, 2) + "\n";
			result += "bne $t0, $t1, " + label + "\n";
			// result += allocation.generateStore(label, 0);
		}
		if (op.equals("==")) {
			result += allocation.generateLoad(y, 1) + "\n";
			result += "";
			result += allocation.generateLoad(z, 2) + "\n";
			result += "beq $t0, $t1, " + label + "\n";
		}
		if (op.equals("<=")) {
			result += allocation.generateLoad(y, 1) + "\n";
			result += "";
			result += allocation.generateLoad(z, 2) + "\n";
			result += "ble $t0, $t1, " + label + "\n";
		}
		if (op.equals(">=")) {
			result += allocation.generateLoad(y, 1) + "\n";
			result += "";
			result += allocation.generateLoad(z, 2) + "\n";
			result += "bge $t0, $t1, " + label + "\n";
		}
		if (op.equals(">")) {
			result += allocation.generateLoad(y, 1) + "\n";
			result += "";
			result += allocation.generateLoad(z, 2) + "\n";
			result += "bgt $t0, $t1, " + label + "\n";
		}
		if (op.equals("<")) {
			result += allocation.generateLoad(y, 1) + "\n";
			result += "";
			result += allocation.generateLoad(z, 2) + "\n";
			result += "blt $t0, $t1, " + label + "\n";
		}

		return result;
	}

	public String toString() {
		return "Branch: b"+cond+", "+y+", "+z+", "+label;
	}
}