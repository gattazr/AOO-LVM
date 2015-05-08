package ricm.aoo.lvm.primit;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;
import ricm.aoo.lvm.kernel.SExpr;
import ricm.aoo.lvm.kernel.SList;
import ricm.aoo.lvm.kernel.Subr;

public class Cdr extends Subr {

	@Override
	public SExpr execPrimitive(MachineLISP aMachineLisp, SExpr aSExpr)
			throws LVMException {
		if (!(aSExpr.car() instanceof SList)) {
			throw new LVMException("*** - CDR: " + aSExpr.car().toString()
					+ " is not a list");
		}
		return aSExpr.car().cdr();
	}

	@Override
	public int numberOfArgs() {
		return 1;
	}

}
