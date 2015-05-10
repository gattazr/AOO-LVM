package ricm.aoo.lvm.primit;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;
import ricm.aoo.lvm.kernel.Atom;
import ricm.aoo.lvm.kernel.SExpr;
import ricm.aoo.lvm.kernel.Subr;
import ricm.aoo.lvm.kernel.Symbol;

public class Implode extends Subr {

	@Override
	public SExpr execPrimitive(MachineLISP aMachineLisp, SExpr aSExpr)
			throws LVMException {
		StringBuilder wBuilder = new StringBuilder();
		SExpr wCur = aSExpr.car();
		int wSize = wCur.size();

		for (int wI = 0; wI < wSize; wI++) {
			if (wCur.car() instanceof Atom) {
				wBuilder.append(wCur.car().toString());
			} else {
				throw new LVMException(
						String.format(
								"*** - IMPLODE: implode param must be a list of symbol, not %s",
								aSExpr));
			}
			wCur = wCur.cdr();
		}

		return new Symbol(wBuilder.toString());
	}

	@Override
	public int numberOfArgs() {
		return 1;
	}

}
