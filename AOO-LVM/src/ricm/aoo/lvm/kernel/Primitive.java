package ricm.aoo.lvm.kernel;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;

public abstract class Primitive extends Atom implements Foncteur {

	public Primitive() {
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
	public final SExpr eval(MachineLISP aMachineLisp) throws LVMException {
		throw new LVMException("Impossible d'évaluer une primitive");
	}

	@Override
	public final SExpr exec(MachineLISP aMachineLisp, SExpr aSExpr)
			throws LVMException {
		SExpr wSExpr;
		int wNArgs;
		int wNSExpr;
		String wPrimName;

		/* Evaluer aSexpr si besoin */
		if (this instanceof Subr) {
			SExpr wCurrent = aSExpr;
			SCons wTemp = new SCons(wCurrent.car().eval(aMachineLisp), Nil.NIL);
			wSExpr = wTemp;

			while (wCurrent.cdr() != Nil.NIL) {
				wTemp.setCdr(new SCons(wCurrent.cdr().car().eval(aMachineLisp),
						Nil.NIL));
				wCurrent = wCurrent.cdr();
				wTemp = (SCons) wTemp.cdr();
			}
		} else {
			wSExpr = aSExpr;
		}

		/* Vérification du nombre d'arguments */
		wNArgs = numberOfArgs();
		wNSExpr = wSExpr.size();
		wPrimName = getClass().getSimpleName().toUpperCase();
		if (wNArgs > wNSExpr) {
			throw new LVMException(String.format(
					"*** - EVAL: too few arguments given to %s : %s",
					wPrimName, new SCons(new Symbol(wPrimName), wSExpr)));
		}
		if (wNArgs < wNSExpr) {
			throw new LVMException(String.format(
					"*** - EVAL: too many arguments given to %s : %s",
					wPrimName, new SCons(new Symbol(wPrimName), wSExpr)));
		}
		/* Exécution de la primitive */
		return execPrimitive(aMachineLisp, wSExpr);
	}

	/**
	 * Execution de la primitive sur une expression
	 *
	 * @param aMachineLisp
	 *            TODO
	 * @param aSExpr
	 *
	 * @return
	 */
	public abstract SExpr execPrimitive(MachineLISP aMachineLisp, SExpr aSExpr)
			throws LVMException;

	/**
	 * Retourne le nombre d'arguments attendus par la primitive
	 *
	 * @return
	 */
	public abstract int numberOfArgs();

}
