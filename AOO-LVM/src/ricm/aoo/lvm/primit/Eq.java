package ricm.aoo.lvm.primit;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;
import ricm.aoo.lvm.kernel.Nil;
import ricm.aoo.lvm.kernel.SExpr;
import ricm.aoo.lvm.kernel.Subr;
import ricm.aoo.lvm.kernel.Symbol;

public class Eq extends Subr {

	@Override
	public SExpr execPrimitive(MachineLISP aMachineLisp, SExpr aSExpr)
			throws LVMException {
		if (aSExpr.car() instanceof ricm.aoo.lvm.kernel.Atom
				&& aSExpr.cdr().car() instanceof ricm.aoo.lvm.kernel.Atom) {
			if (aSExpr.car().equals(aSExpr.cdr().car())) {
				return new Symbol("T");
			}
			return Nil.NIL;
		}
		return Nil.NIL;
	}

	@Override
	public int numberOfArgs() {
		return 2;
	}

}