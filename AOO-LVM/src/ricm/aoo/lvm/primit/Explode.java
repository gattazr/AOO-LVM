package ricm.aoo.lvm.primit;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;
import ricm.aoo.lvm.kernel.Atom;
import ricm.aoo.lvm.kernel.Nil;
import ricm.aoo.lvm.kernel.SCons;
import ricm.aoo.lvm.kernel.SExpr;
import ricm.aoo.lvm.kernel.Subr;
import ricm.aoo.lvm.kernel.Symbol;

public class Explode extends Subr {

	@Override
	public SExpr execPrimitive(MachineLISP aMachineLisp, SExpr aSExpr)
			throws LVMException {
		SExpr wParam = aSExpr.car();
		if (!(wParam instanceof Atom)) {
			throw new LVMException(String.format(
					"*** - EXPLODE: param must be a symbol, not %s",
					aSExpr.car()));
		}
		String wAtom = wParam.toString();
		SExpr wSExpr = Nil.NIL;
		for (int wI = wAtom.length() - 1; wI > -1; wI--) {
			char wChar = wAtom.charAt(wI);
			wSExpr = new SCons(new Symbol("" + wChar), wSExpr);
		}
		return wSExpr;
	}

	@Override
	public int numberOfArgs() {
		return 1;
	}

}
