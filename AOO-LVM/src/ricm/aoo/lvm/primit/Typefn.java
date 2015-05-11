package ricm.aoo.lvm.primit;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;
import ricm.aoo.lvm.kernel.FSubr;
import ricm.aoo.lvm.kernel.SCons;
import ricm.aoo.lvm.kernel.SExpr;
import ricm.aoo.lvm.kernel.Subr;
import ricm.aoo.lvm.kernel.Symbol;

public class Typefn extends Subr {

	@Override
	public SExpr execPrimitive(MachineLISP aMachineLisp, SExpr aSExpr)
			throws LVMException {
		SExpr wFunction = aSExpr.car();
		if (wFunction instanceof Subr) {
			return new Symbol("SUBR");
		}
		if (wFunction instanceof FSubr) {
			return new Symbol("FSUBR");
		}
		if (wFunction instanceof SCons) {
			if (wFunction.car().toString().equals("LAMBDA")) {
				return new Symbol("LAMBDA");
			}
			if (wFunction.car().toString().equals("FLAMBDA")) {
				return new Symbol("FLAMBDA");
			}
		}
		throw new LVMException("*** - TYPEFN: this is not a function");
	}

	@Override
	public int numberOfArgs() {
		return 1;
	}

}
