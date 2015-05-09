package ricm.aoo.lvm.kernel;

import ricm.aoo.lvm.Context;
import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;

public class Expr extends Fonction {

	@Override
	public SExpr exec(MachineLISP aMachineLisp, SExpr aSExpr)
			throws LVMException {

		SExpr wLambda = aSExpr.car();
		int wNFonctParams;
		int wNEffectParams;
		SExpr wEffectParams = Nil.NIL;
		/* Vérification que lambda est correct */
		if (!(wLambda.size() == 3 && wLambda.cdr().car() instanceof SList)) {
			throw new LVMException(
					"*** - EVAL: wrong format for lambda. Expects (LAMBDA SYMBOL LIST LIST|SYMBOL)");
		}

		wNFonctParams = wLambda.cdr().car().size();
		wNEffectParams = aSExpr.cdr().size();

		if (wNFonctParams > wNEffectParams) {
			throw new LVMException(String.format(
					"*** - EVAL: too few arguments given to LAMBDA : %s",
					aSExpr.cdr()));
		}
		if (wNFonctParams < wNEffectParams) {
			throw new LVMException(String.format(
					"*** - EVAL: too many arguments given to LAMBDA : %s",
					aSExpr.cdr()));
		}

		/* Méthode un peu lourdre mais permet de garder SCons immuables */
		SExpr wNext = Nil.NIL;
		for (int wI = wNEffectParams; wI > 0; wI--) {
			SExpr wTemp = aSExpr.cdr();
			for (int wJ = 1; wJ < wI; wJ++) {
				wTemp = wTemp.cdr();
			}
			wTemp = wTemp.car();
			wEffectParams = new SCons(wTemp.eval(aMachineLisp), wNext);
			wNext = wEffectParams;
		}

		/* Lien entre les params fonctionels et paramètres effectifs */
		SExpr wCurFonct = wLambda.cdr().car();
		SExpr wCurEffect = wEffectParams;
		Context wContext = aMachineLisp.getContext();
		for (int wI = 0; wI < wNEffectParams; wI++) {
			if (wCurFonct.car() instanceof Symbol) {
				wContext.addToContext((Symbol) wCurFonct.car(),
						wCurEffect.car());
			} else {
				throw new LVMException(
						String.format(
								"*** - LAMBDA: functional parameter name must be a symbol, not %s",
								wCurFonct.car()));
			}
			wCurFonct = wCurFonct.cdr();
			wCurEffect = wCurEffect.cdr();
		}

		/* Evaluation du lambda */
		return wLambda.cdr().cdr().car().eval(aMachineLisp);
	}
}
