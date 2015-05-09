package ricm.aoo.lvm.primit;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;
import ricm.aoo.lvm.kernel.FSubr;
import ricm.aoo.lvm.kernel.SExpr;

public class Apply extends FSubr {

	@Override
	public SExpr execPrimitive(MachineLISP aMachineLisp, SExpr aSExpr)
			throws LVMException {
		return aSExpr.eval(aMachineLisp);
	}

	@Override
	public int numberOfArgs() {
		return 2;
	}

}
