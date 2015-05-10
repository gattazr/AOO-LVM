package ricm.aoo.lvm.primit;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;
import ricm.aoo.lvm.kernel.Nil;
import ricm.aoo.lvm.kernel.SExpr;
import ricm.aoo.lvm.kernel.SList;
import ricm.aoo.lvm.kernel.Subr;

public class Eprogn extends Subr {

	@Override
	public SExpr execPrimitive(MachineLISP aMachineLisp, SExpr aSExpr)
			throws LVMException {

		SExpr wList = aSExpr.car();
		if (!(wList instanceof SList)) {
			throw new LVMException(String.format(
					"*** -EPROGN: param must be a list, not %s", aSExpr));
		}
		int wSize = wList.size();
		SExpr wRes = Nil.NIL;

		for (int wI = 0; wI < wSize; wI++) {
			wRes = wList.car().eval(aMachineLisp);
			wList = wList.cdr();
		}

		return wRes;
	}

	@Override
	public int numberOfArgs() {
		return 1;
	}

}
