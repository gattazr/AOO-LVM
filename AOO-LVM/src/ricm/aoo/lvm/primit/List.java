package ricm.aoo.lvm.primit;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;
import ricm.aoo.lvm.kernel.SExpr;
import ricm.aoo.lvm.kernel.Subr;

public class List extends Subr {

	@Override
	public SExpr execPrimitive(MachineLISP aMachineLisp, SExpr aSExpr)
			throws LVMException {
		return aSExpr;
	}

	@Override
	public int numberOfArgs() {
		return 1;
	}

}
