package ricm.aoo.lvm.primit;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;
import ricm.aoo.lvm.kernel.FSubr;
import ricm.aoo.lvm.kernel.SCons;
import ricm.aoo.lvm.kernel.SExpr;
import ricm.aoo.lvm.kernel.Symbol;

public class Df extends FSubr {

	@Override
	public SExpr execPrimitive(MachineLISP aMachineLisp, SExpr aSExpr)
			throws LVMException {
		if (!(aSExpr.car() instanceof Symbol)) {
			throw new LVMException(
					String.format(
							"*** - DF: the name of a function must be a symbol, not %s",
							aSExpr.car()));
		}
		aMachineLisp.getContext().addToContextGeneral((Symbol) aSExpr.car(),
				new SCons(new Symbol("flambda"), aSExpr.cdr()));
		return aSExpr.car();
	}

	@Override
	public int numberOfArgs() {
		return 3;
	}

}
