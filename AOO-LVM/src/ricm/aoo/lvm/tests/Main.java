package ricm.aoo.lvm.tests;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;
import ricm.aoo.lvm.Reader;
import ricm.aoo.lvm.kernel.SExpr;

public class Main {

	public static void main(String[] aArgs) {
		MachineLISP wMachine = new MachineLISP();
		SExpr wExpr;
		String wDEBUG = System.getProperty("DEBUG");
		while (true) {
			try {
				wMachine.getContext().popAllContexts();
				/* Affichage de DEBUG */
				if (wDEBUG != null && !wDEBUG.toLowerCase().equals("false")) {
					System.out.println(wMachine.getContext());
				}
				System.out.print("> ");
				wExpr = Reader.read();
				System.out.println(wExpr.eval(wMachine).toString());
			} catch (LVMException aException) {
				System.out.println(aException.getMessage());
			}
		}
	}
}
