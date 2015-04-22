package ricm.aoo.lvm.kernel;

import ricm.aoo.lvm.Context;
import ricm.aoo.lvm.LVMException;

public interface SExpr {

	/**
	 *
	 * @return car de l'expression
	 * @throws LVMException
	 */
	public SExpr car() throws LVMException;

	/**
	 *
	 * @return cdr de l'expression
	 * @throws LVMException
	 */
	public SExpr cdr() throws LVMException;

	/**
	 *
	 * Evaluation de l'expression
	 *
	 * @param aContext
	 *            TODO
	 *
	 * @return TODO
	 *
	 * @throws LVMException
	 */
	public SExpr eval(Context aContext) throws LVMException;

	@Override
	public String toString();

}
