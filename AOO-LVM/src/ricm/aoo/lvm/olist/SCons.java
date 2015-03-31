package ricm.aoo.lvm.olist;

import ricm.aoo.lvm.utils.LVMException;

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
	public String toString() {
		StringBuilder wString = new StringBuilder();

		wString.append("( " + this.pCar.toString());

		if (!(this.pCdr instanceof Nil)) {
			wString.append(" . " + this.pCdr.toString());
		}

		return wString.append(" )").toString();
	}
}
