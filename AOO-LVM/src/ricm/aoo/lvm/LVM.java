package ricm.aoo.lvm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import ricm.aoo.lvm.kernel.SExpr;
import ricm.aoo.lvm.kernel.Symbol;

public class LVM {

	public static void main(String[] aArgs) {
		LVM wLVM = new LVM();
		MachineLISP wMachineLISP = wLVM.initEnv();
		wLVM.topLevel(wMachineLISP);
		wLVM.quit();
	}

	public LVM() {
		Console.println("Hello !");
	}

	public MachineLISP initEnv() {
		MachineLISP wMachine = new MachineLISP();

		BufferedReader wBuffer = null;
		try {
			String wLine;
			wBuffer = new BufferedReader(new FileReader("ressources/lisp.txt"));

			while ((wLine = wBuffer.readLine()) != null) {
				Reader.read(wLine).eval(wMachine);
			}

		} catch (IOException aException) {
			Console.printStack(aException);
			System.err
			.println("Erreur durant l'initialisation de l'environnement");
			System.exit(1);
		} catch (LVMException wException) {
			Console.printStack(wException);
			System.err
			.println("Erreur durant l'initialisation de l'environnement");
			System.exit(1);
		} finally {
			try {
				if (wBuffer != null) {
					wBuffer.close();
				}
			} catch (IOException aException) {
				Console.printStack(aException);
			}
		}

		return wMachine;
	}

	public void quit() {
		Console.println("Goodbye");
	}

	public void topLevel(MachineLISP aMachineLisp) {

		SExpr wSExpr;
		while (true) {
			aMachineLisp.getContext().popAllContexts();
			/* Affichage de DEBUG */
			Console.debug(aMachineLisp.getContext().toString());
			Console.print("> ");
			try {
				wSExpr = Reader.read();
				if (wSExpr instanceof Symbol
						&& wSExpr.equals(new Symbol("quit"))) {
					break;
				}
				Console.println(wSExpr.eval(aMachineLisp).toString());
			} catch (LVMException aException) {
				Console.println(aException.getMessage());
				Console.printStack(aException);
			}
		}
	}
}
