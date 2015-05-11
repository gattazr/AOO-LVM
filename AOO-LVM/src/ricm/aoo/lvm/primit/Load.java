package ricm.aoo.lvm.primit;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import ricm.aoo.lvm.Console;
import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;
import ricm.aoo.lvm.Reader;
import ricm.aoo.lvm.kernel.Nil;
import ricm.aoo.lvm.kernel.SExpr;
import ricm.aoo.lvm.kernel.Subr;
import ricm.aoo.lvm.kernel.Symbol;

public class Load extends Subr {

	@Override
	public SExpr execPrimitive(MachineLISP aMachineLisp, SExpr aSExpr)
			throws LVMException {
		SExpr wName = aSExpr.car();
		if (!(wName instanceof Symbol)) {
			throw new LVMException(String.format(
					"*** - LOAD: param must be a SYMBOL, not %s", aSExpr));
		}
		String wFileName = wName.toString();
		if (!(new File(wFileName).isFile())) {
			throw new LVMException(String.format(
					"*** - LOAD: file %s not found", wFileName));
		}

		SExpr wReturn = new Symbol("T");
		BufferedReader wBuffer = null;
		try {
			wBuffer = new BufferedReader(new FileReader(wFileName));
			Reader wReader = new Reader(wBuffer);

			/* eval toutes les lignes du fichier */
			while (true) {
				Reader.importe(wReader).eval(aMachineLisp);
			}

		} catch (EOFException aException) {
			/* Le fichier a été lu */
		} catch (IOException aException) {
			Console.printStack(aException);
			System.err.println(String.format(
					"*** - LOAD: Reading the file %s created an error",
					wFileName));
			wReturn = Nil.NIL;
		} catch (LVMException wException) {
			Console.printStack(wException);
			/* Présente l'erreur et arrête l'éxécution du fichier */
			Console.println(wException.getMessage());
			wReturn = Nil.NIL;
		} finally {
			try {
				if (wBuffer != null) {
					wBuffer.close();
				}
			} catch (IOException aException) {
				Console.printStack(aException);
			}
		}

		/* Retourne Nil si l'éxécution a généré une erreur */
		/* T sinon */
		return wReturn;
	}

	@Override
	public int numberOfArgs() {
		return 1;
	}

}
