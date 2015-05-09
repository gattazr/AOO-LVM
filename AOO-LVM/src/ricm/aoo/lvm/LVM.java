package ricm.aoo.lvm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LVM {

	public static void main(String[] aArgs) {
		LVM wLVM = new LVM();
		MachineLISP wMachineLISP = wLVM.initEnv();
		try {
			Reader.read("(toplevel)").eval(wMachineLISP);
		} catch (LVMException aException) {
			Console.println(aException.getMessage());
			Console.printStack(aException);
		}
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

}
