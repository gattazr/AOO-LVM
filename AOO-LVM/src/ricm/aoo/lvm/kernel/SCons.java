package ricm.aoo.lvm.kernel;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;

public class SCons implements SList {

	protected SExpr pCar;
	protected SExpr pCdr;

	public SCons(SExpr aCar, SExpr aCdr) {
		this.pCar = aCar; // Ce serait mieux d'utiliser une copie
		this.pCdr = aCdr; // Ce serait mieux d'utiliser une copie
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
		/*
		 * switch(Evaluation du car de la SExpr)
		 *
		 * Si PRIMITIVE : execution avec en paramètre la liste des arguments
		 * (cdr)
		 *
		 * Si SCONS : Evaluation de la SCONS ? -> Recherche de EXPR ou FEXPR
		 * avec lambda ou flamba + Excecution de la Lamba ou FLambda
		 *
		 * Si Autre : LVMException
		 */
		SExpr wFoncteur;
		wFoncteur = car().eval(aMachineLisp);

		if (wFoncteur instanceof Primitive) {
			return ((Primitive) wFoncteur).exec(aMachineLisp, cdr());
		}
		if (wFoncteur instanceof SCons) {
			Fonction wFunc = null;
			if (wFoncteur.car().toString().equals("LAMBDA")) {
				/* Expr */
				wFunc = new Expr();
			} else if (wFoncteur.car().toString().equals("FLAMBDA")) {
				/* FExpr */
				wFunc = new Fexpr();
			}
			if (wFunc != null) {
				aMachineLisp.getContext().pushContext();
				SExpr wRes = wFunc.exec(aMachineLisp, new SCons(wFoncteur,
						cdr()));
				aMachineLisp.getContext().popContext();
				return wRes;
			}
		}

		throw new LVMException(String.format(
				"*** - EVAL: undefined function %s", wFoncteur));
	}

	@Override
	public int size() throws LVMException {
		return 1 + cdr().size();
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
