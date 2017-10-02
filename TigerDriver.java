public class TigerDriver {
	public static void main(String[] args) {
		TigerScanner ts = new TigerScanner(args[0]);

		while(ts.hasNext()) {
			try {
				System.out.println(ts.next());
			} catch (Exception se) {
				print(se)
			}
		}
	}
}