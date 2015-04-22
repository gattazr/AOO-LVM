package ricm.aoo.lvm.kernel;

import ricm.aoo.lvm.Context;
import ricm.aoo.lvm.LVMException;

public interface Fonction {

	/**
	 * TODO: comments
	 *
	 * @param aContext
	 * @param aSExpr
	 * @return
	 * @throws LVMException
	 */
	SExpr exec(Context aContext, SExpr aSExpr) throws LVMException;

	/**
	 * TODO: comments
	 *
	 * @param aSExpr
	 * @return
	 */
	SExpr execPrimitive(SExpr aSExpr) throws LVMException;

	/**
	 * TODO: comments
	 *
	 * @return
	 */
	boolean needEvaluation();
}
