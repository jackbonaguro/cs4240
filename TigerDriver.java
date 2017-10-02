import java.io.EOFException;

public class TigerDriver {
	public static void main(String[] args) {
		TigerScanner ts = new TigerScanner(args[0]);

		boolean run = true;

		while(run) {
			try {
				System.out.println(ts.next());
			} catch (EOFException eof) { 
				run = false;
			} catch (Exception se) {
				System.out.println(se);
			}
		}
	}
}