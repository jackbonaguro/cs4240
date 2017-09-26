public TigerScannerDFA {

	public class DFAKey {
		public int state;
		public String transition;

		public DFAKey(int s, String t) {
			this.state = s;
			this.transition = t;
		}
	}

	public class DFAValue {
		public int state;
		public boolean valid;
		public boolean error;
		public boolean whitespace;

		public DFAKey(int s, boolean v, boolean e, boolean w) {
			this.state = s;
			this.valid = v;
			this.error = e;
			this.whitespace = w;
		}
	}

	public Map<DFAKey, DFAValue> map = new HashMap<DFAKey, DFAValue>();

	public TigerScannerDFA() {
		this.map.put(new DFAKey(0, a), new DFAValue(1, false, false, false));
	}
}