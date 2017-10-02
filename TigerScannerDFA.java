import java.util.Map;
import java.util.HashMap;

public class TigerScannerDFA {

	public static class DFAKey {
		public int state;
		public String transition;

		public DFAKey(int s, String t) {
			this.state = s;
			this.transition = t;
		}
	}

	public static class DFAValue {
		public int state;
		public boolean valid;
		public boolean error;
		public boolean whitespace;

		public DFAValue(int s, boolean v, boolean e, boolean w, boolean c) {
			this.state = s;
			this.valid = v;
			this.error = e;
			this.whitespace = w;
			//this.comment = c;
		}
	}

	public Map<DFAKey, DFAValue> map = new HashMap<DFAKey, DFAValue>();
	public Map<Integer, TokenType> tokens = new HashMap<Integer, TokenType>();

	public TigerScannerDFA() {
		this.map.put(new DFAKey(0,"a"), new DFAValue(1,false,false,false,false));

		this.tokens.put(new Integer(2), TokenType.COMMA);
	}
}