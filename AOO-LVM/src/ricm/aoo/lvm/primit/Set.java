package ricm.aoo.lvm.primit;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;
import ricm.aoo.lvm.kernel.FSubr;
import ricm.aoo.lvm.kernel.SExpr;
import ricm.aoo.lvm.kernel.Symbol;

public class Set extends FSubr {

	@Override
	public SExpr execPrimitive(MachineLISP aMachineLisp, SExpr aSExpr)
			throws LVMException {
		SExpr wValue;

		if (!(aSExpr.car() instanceof Symbol)) {
			throw new LVMException(
					String.format(
							"*** - Set: the name of a variable must be a symbol, not %s",
							aSExpr.car()));
		}

		wValue = aSExpr.cdr().car().eval(aMachineLisp);
		aMachineLisp.getContext().addToContext((Symbol) aSExpr.car(), wValue);

		return wValue;
	}

	@Override
	public int numberOfArgs() {
		return 2;
	}

}
