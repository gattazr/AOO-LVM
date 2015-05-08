package ricm.aoo.lvm.kernel;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;

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
	 * Evaluation de l'expression
	 *
	 * @param aMachineLisp
	 * @return
	 * @throws LVMException
	 */
	public SExpr eval(MachineLISP aMachineLisp) throws LVMException;

	/**
	 *
	 * Calcule la taille de la SExpr. 0 pour NIL, 1 si il s'agit d'un atome, le
	 * nombre d'élement dans la liste sinon.
	 *
	 * @return
	 */
	public int size() throws LVMException;

	@Override
	public String toString();

}
