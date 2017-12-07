import java.util.ArrayList;

public class Allocation {
	public enum RegType {
		Variable,
		Temp,
		Literal
	}

	public ArrayList<String> variables;
	public ArrayList<ArrayTuple> arrays;

	public Allocation() {
		this(new ArrayList<String>(), new ArrayList<ArrayTuple>());
	}

	public Allocation(ArrayList<String> variables, ArrayList<ArrayTuple> arrays) {
		this.variables = variables;
		this.arrays = arrays;
	}

	public String generateAddress(String value, int num) {
		return "la $t"+num+", "+value;
	}

	public String generateStore(String value, int num) {
		//try {
			RegType rt = this.getOperandType(value);
			return this.generateStore(rt, value, num);
		/*} catch (Exception e) {
			System.out.println("Bad Operand");
			return "";
		}*/
	}

	public String generateStore(RegType rt, String value, int num) {
		value = value.trim();
		switch (rt) {
			case Variable:
				return "sw $t"+num+", "+value;
			case Temp:
				String n = value.substring(1,value.length());
				int tempNum = Integer.parseInt(n);
				return "sw $t"+num+", -"+tempNum+"($sp)";
			default:
				return "";
		}
	}

	public String generateLoad(String value, int num) {
		//try {
			RegType rt = this.getOperandType(value);
			return this.generateLoad(rt, value, num);
		/*} catch (Exception e) {
			System.out.println("Bad Operand");
			return "";
		}*/
	}

	public String generateLoad(RegType rt, String value, int num) {
		value = value.trim();
		switch (rt) {
			case Variable:
				return "lw $t"+num+", "+value;
			case Temp:
				int tempNum = Integer.parseInt(value.substring(1,value.length()));
				return "lw $t"+num+", -"+tempNum+"($sp)";
			case Literal:
				return "addi $t"+num+", $0, "+value;
			default:
				return "";
		}
	}

	public RegType getOperandType(String o) {
		o = o.trim();
		//First look for variables
		if (variables.contains(o)) {
			return RegType.Variable;
		} else {
			try {
				Integer.parseInt(o.substring(0,o.length()));
				return RegType.Literal;
			} catch (NumberFormatException nfe) {
				//Wasn't an int... let's try float
			}
			try {
				Float.parseFloat(o.substring(0,o.length()));
				return RegType.Literal;
			} catch (Exception e) {
				//Wasn't a float either
			}
			//Maybe it's a temp variable
			if (o.substring(0,1).equals("t")) {
				//Ex. t1, t2, ...
				try {
					String n = o.substring(1,o.length());
					Integer.parseInt(n);
					return RegType.Temp;
				} catch (NumberFormatException e) {
					//Not a temp variable,
					//Thus not any of the types
					return null;
				}
			} else {
				//Not any existing thing
				//Must be a new variable
				return null;
			}
		}
	}
}