package ricm.aoo.lvm.primit;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;
import ricm.aoo.lvm.kernel.FSubr;
import ricm.aoo.lvm.kernel.Nil;
import ricm.aoo.lvm.kernel.SExpr;

public class Cond extends FSubr {

	@Override
	public SExpr execPrimitive(MachineLISP aMachineLisp, SExpr aSExpr)
			throws LVMException {
		SExpr wCurrent = aSExpr;
		SExpr wResult = Nil.NIL;
		while (wCurrent.car() != Nil.NIL) {
			SExpr wCurrentCond = wCurrent.car();
			if (wCurrentCond.size() != 2) {
				throw new LVMException(
						String.format(
								"*** COND: a cond statement is a list of 2 SYMBOL|LIST. %s doesn't have the right format",
								wCurrentCond));
			}
			if (wCurrentCond.car().eval(aMachineLisp) != Nil.NIL) {
				/* La condition est vrai puisque différente de Nil */
				wResult = wCurrentCond.cdr().car().eval(aMachineLisp);
				break;
			}
			wCurrent = wCurrent.cdr();
		}
		/* retourne NIL si aucune condition dans le cond n'est vérifié */
		return wResult;
	}

	@Override
	public int numberOfArgs() {
		return Integer.MAX_VALUE;
	}

}
