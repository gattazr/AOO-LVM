package ricm.aoo.lvm.primit;

import ricm.aoo.lvm.Console;
import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;
import ricm.aoo.lvm.kernel.Nil;
import ricm.aoo.lvm.kernel.SExpr;
import ricm.aoo.lvm.kernel.Subr;

public class Print extends Subr {

	@Override
	public SExpr execPrimitive(MachineLISP aMachineLisp, SExpr aSExpr)
			throws LVMException {
		int wSize = aSExpr.size();
		SExpr wCourant = Nil.NIL;
		SExpr wNext = aSExpr;
		for (int wI = 0; wI < wSize; wI++) {
			wCourant = wNext;
			Console.print(wCourant.car().toString());
			wNext = wCourant.cdr();
		}
		Console.println();
		return wCourant.car();
	}

	@Override
	public int numberOfArgs() {
		return Integer.MAX_VALUE;
	}

}
