public TigerScannerDFA {

	public class DFAKey {
		public int state;
		public String char;

		public DFAKey(int s, String c) {
			this.state = s;
			this.char = c;
		}
	}

	public class DFAValue {
		public int state;
		public boolean valid;
		public boolean error;

		public DFAKey(int s, boolean v, boolean e) {
			this.state = s;
			this.valid = v;
			this.error = e;
		}
	}

	public Map<DFAKey, DFAValue> map = new HashMap<DFAKey, DFAValue>();

	public TigerScannerDFA() {
		this.map.put(new DFAKey(0, a), new DFAValue(1, false, false));
	}
}