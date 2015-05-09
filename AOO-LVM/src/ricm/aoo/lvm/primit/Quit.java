package ricm.aoo.lvm.primit;

import ricm.aoo.lvm.Console;
import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;
import ricm.aoo.lvm.kernel.FSubr;
import ricm.aoo.lvm.kernel.Nil;
import ricm.aoo.lvm.kernel.SExpr;

public class Quit extends FSubr {

	@Override
	public SExpr execPrimitive(MachineLISP aMachineLisp, SExpr aSExpr)
			throws LVMException {
		Console.println("Goodbye !");
		System.exit(0);
		return Nil.NIL;
	}

	@Override
	public int numberOfArgs() {
		return 0;
	}

}
