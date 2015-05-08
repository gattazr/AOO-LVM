package ricm.aoo.lvm.tests;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;
import ricm.aoo.lvm.Reader;
import ricm.aoo.lvm.kernel.SExpr;

public class Main {

	public static void main(String[] aArgs) {
		MachineLISP wMachine = new MachineLISP();
		SExpr wExpr;

		while (true) {
			try {
				System.out.print("> ");
				wExpr = Reader.read();
				System.out.println(wExpr.eval(wMachine).toString());
			} catch (LVMException aException) {
				System.out.println(aException.getMessage());
			}
		}
	}

}
