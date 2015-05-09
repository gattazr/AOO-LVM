package ricm.aoo.lvm.primit;

import ricm.aoo.lvm.Console;
import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;
import ricm.aoo.lvm.Reader;
import ricm.aoo.lvm.kernel.SExpr;
import ricm.aoo.lvm.kernel.Subr;

public class TopLevel extends Subr {

	@Override
	public SExpr execPrimitive(MachineLISP aMachineLisp, SExpr aSExpr)
			throws LVMException {
		while (true) {
			aMachineLisp.getContext().popAllContexts();
			/* Affichage de DEBUG */
			Console.debug(aMachineLisp.getContext().toString());
			Console.print("> ");
			try {
				Console.println(Reader.read().eval(aMachineLisp).toString());
			} catch (LVMException aException) {
				Console.println(aException.getMessage());
				Console.printStack(aException);
			}
		}
	}

	@Override
	public int numberOfArgs() {
		return 0;
	}

}
