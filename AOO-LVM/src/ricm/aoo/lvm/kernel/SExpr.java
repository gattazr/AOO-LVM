package ricm.aoo.lvm.kernel;

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
	 * @return TODO
	 *
	 * @throws LVMException
	 */
	public SExpr eval() throws LVMException;

	@Override
	public String toString();

}
