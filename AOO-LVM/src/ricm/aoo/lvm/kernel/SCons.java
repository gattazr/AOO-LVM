package ricm.aoo.lvm.kernel;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;

public class SCons implements SList {

	protected SExpr pCar;
	protected SExpr pCdr;

	public SCons(SExpr aCar, SExpr aCdr) {
		this.pCar = aCar; // Ce serait mieux d'utiliser une copies
		this.pCar = aCdr; // Ce serait mieux d'utiliser une copies
	}

	@Override
	public SExpr car() throws LVMException {
		return this.pCar; // Ce serait mieux de retourner une copie
	}

	@Override
	public SExpr cdr() throws LVMException {
		return this.pCdr; // Ce serait mieux de retourner une copie
	}

	@Override
	public SExpr eval(MachineLISP aMachineLisp) throws LVMException {
		return null; // TODO: make function
		/*
		 *
		 * Primitive prim ( = car() ) Expr expr = car() Si car() instanceof
		 * Symbole {
		 *
		 * Si prim instanceof Primitive { return prim.exec(cdr()) }
		 *
		 * Si expr instanceof Expr { return expr.exec(cdr()) }
		 *
		 * }
		 *
		 * Sinon throw new LVMException
		 */
	}

	@Override
	public String toString() {
		StringBuilder wString = new StringBuilder();

		wString.append("( " + this.pCar.toString());

		if (!(this.pCdr instanceof Nil)) {
			wString.append(" . " + this.pCdr.toString());
		}

		return wString.append(" )").toString();
	}
}
