package ricm.aoo.lvm.primit;

import ricm.aoo.lvm.Console;
import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;
import ricm.aoo.lvm.kernel.SExpr;
import ricm.aoo.lvm.kernel.Subr;

public class Print extends Subr {

	@Override
	public SExpr execPrimitive(MachineLISP aMachineLisp, SExpr aSExpr)
			throws LVMException {
		int wSize = aSExpr.size();
		SExpr wCourant = aSExpr;
		for (int wI = 0; wI < wSize - 1; wI++) {
			Console.print(wCourant.car().toString());
			wCourant = wCourant.cdr();
		}
		return wCourant;
	}

	@Override
	public int numberOfArgs() {
		return Integer.MAX_VALUE;
	}

}
