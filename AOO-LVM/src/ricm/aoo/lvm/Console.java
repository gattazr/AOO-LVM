package ricm.aoo.lvm;

import jus.util.IO;

public class Console {

	public static void debug(String aString) {
		if (System.getProperty("DEBUG") != null) {
			System.err.println(aString);
		}
	}

	public static void print(String aString) {
		IO.print(aString);
	}

	public static void println() {
		IO.println();
	}

	public static void println(String aString) {
		IO.println(aString);
	}

	public static void printStack(Throwable aThrowable) {
		if (System.getProperty("DEBUG") != null) {
			aThrowable.printStackTrace();
		}
	}

	public static void prompt(String aString) {
		System.out.print(aString);
	}

	public static void resetOut() {
		IO.resetOut();
	}

	public static void setOut() {
		IO.setOut();
	}

	public static void setOut(String aFileName) {
		IO.setOut(aFileName);
	}

}
