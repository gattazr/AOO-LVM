package ricm.aoo.lvm;

import ricm.aoo.lvm.kernel.SExpr;
import ricm.aoo.lvm.kernel.Symbol;

public class LVM {

	public static void main(String[] aArgs) {
		LVM wLVM = new LVM();
		wLVM.topLevel();
		wLVM.quit();
	}

	public LVM() {
		Console.println("Hello !");
	}

	public void quit() {
		Console.println("Goodbye");
	}

	public void topLevel() {
		MachineLISP wMachine = new MachineLISP();
		SExpr wSExpr;
		while (true) {
			wMachine.getContext().popAllContexts();
			/* Affichage de DEBUG */
			Console.debug(wMachine.getContext().toString());
			Console.print("> ");
			try {
				wSExpr = Reader.read();
				if (wSExpr instanceof Symbol
						&& wSExpr.equals(new Symbol("quit"))) {
					break;
				}
				Console.println(wSExpr.eval(wMachine).toString());
			} catch (LVMException aException) {
				Console.printStack(aException);
			}
		}
	}
}
