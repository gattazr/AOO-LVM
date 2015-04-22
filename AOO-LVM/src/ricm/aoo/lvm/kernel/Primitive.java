package ricm.aoo.lvm.kernel;

import ricm.aoo.lvm.Context;
import ricm.aoo.lvm.LVMException;

public abstract class Primitive extends Atom implements Fonction {

	public Primitive() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public final SExpr car() throws LVMException {
		throw new LVMException(
				"Impossible d'appeler la fonction car sur une primitive");
	}

	@Override
	public final SExpr cdr() throws LVMException {
		throw new LVMException(
				"Impossible d'appeler la fonction cdr sur une primitive");
	}

	@Override
	public final SExpr eval(Context aContext) throws LVMException {
		throw new LVMException("Impossible d'évaluer une primitive");
	}

	@Override
	public final SExpr exec(Context aContext, SExpr aSExpr) throws LVMException {
		if (needEvaluation()) {
			return execPrimitive(aSExpr.eval(aContext));
		}
		return execPrimitive(aSExpr);
	}

}
