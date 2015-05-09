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
		SExpr wSExpr = Nil.NIL;
		int wNArgs;
		int wNSExpr;
		String wPrimName;

		/* Vérification du nombre d'arguments */
		wNArgs = numberOfArgs();
		wNSExpr = aSExpr.size();
		wPrimName = getClass().getSimpleName().toUpperCase();
		if (wNArgs > wNSExpr) {
			throw new LVMException(String.format(
					"*** - EVAL: too few arguments given to %s : %s",
					wPrimName, new SCons(new Symbol(wPrimName), aSExpr)));
		}
		if (wNArgs < wNSExpr) {
			throw new LVMException(String.format(
					"*** - EVAL: too many arguments given to %s : %s",
					wPrimName, new SCons(new Symbol(wPrimName), aSExpr)));
		}

		/* Evaluer aSexpr si besoin */
		if (this instanceof Subr) {
			/* Méthode un peu lourdre mais permet de garder SCons immuables */
			SExpr wNext = Nil.NIL;
			for (int wI = wNArgs; wI > 0; wI--) {
				SExpr wTemp = aSExpr;
				for (int wJ = 1; wJ < wI; wJ++) {
					wTemp = wTemp.cdr();
				}
				wTemp = wTemp.car();
				wSExpr = new SCons(wTemp.eval(aMachineLisp), wNext);
				wNext = wSExpr;
			}
		} else {
			wSExpr = aSExpr;
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
