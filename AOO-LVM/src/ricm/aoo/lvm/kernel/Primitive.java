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
		SExpr wSExpr = aSExpr;
		int wNArgs;
		int wNSExpr;
		String wPrimName;

		/*
		 * Evaluer si besoin aSexpr -> il faut évaluer chaque élement de la
		 * liste de façon indépendante
		 */
		// if (this instanceof Subr) {
		// wSExpr = aSExpr.eval(aMachineLisp);
		// }

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
