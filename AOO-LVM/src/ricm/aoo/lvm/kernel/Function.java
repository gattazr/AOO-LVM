package ricm.aoo.lvm.kernel;

import ricm.aoo.lvm.Context;
import ricm.aoo.lvm.LVMException;

public abstract class Function implements Fonction {

	@Override
	public final SExpr exec(Context aContext, SExpr aSExpr) throws LVMException {
		if (needEvaluation()) {
			return execPrimitive(aSExpr.eval(aContext));
		}
		return execPrimitive(aSExpr);
	}

}
