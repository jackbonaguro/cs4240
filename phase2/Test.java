import java.util.ArrayList;

public class Test {

	public enum RegType {
		Variable,
		Temp,
		Literal
	}

	public static ArrayList<String> variables;
	public static ArrayList<ArrayTuple> arrays;

	public static void main(String[] args) {
		String o = "t11";
		System.out.println(o);
		try {
			Integer.parseInt(o.substring(0,o.length()));
			return;// RegType.Literal;
		} catch (NumberFormatException nfe) {
			//Wasn't an int... let's try float
		}
		try {
			Float.parseFloat(o.substring(0,o.length()));
			return;// RegType.Literal;
		} catch (Exception e) {
			//Wasn't a float either
		}
		//Maybe it's a temp variable
		if (o.substring(0,1).equals("t")) {
			//Ex. t1, t2, ...
			try {
				System.out.println(o.length());
				String n = o.substring(1,o.length()).trim();
				System.out.println(n.charAt(0));
				System.out.println(n.charAt(1));
				int a = Integer.parseInt(n);
				System.out.println(a);
				return;// RegType.Temp;
			} catch (NumberFormatException e) {
				//Not a temp variable,
				//Thus not any of the types
				System.out.println("NumberFormatException");
				return;// null;
			}
		} else {
			//Not any existing thing
			//Must be a new variable
			return;// null;
		}
	}
}