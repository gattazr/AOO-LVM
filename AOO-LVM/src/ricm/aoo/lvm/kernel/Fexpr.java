package ricm.aoo.lvm.kernel;

import ricm.aoo.lvm.Context;
import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;

public class Fexpr extends Fonction {

	@Override
	public SExpr exec(MachineLISP aMachineLisp, SExpr aSExpr)
			throws LVMException {

		SExpr wLambda = aSExpr.car();
		int wNFonctParams;
		int wNEffectParams;
		/* Vérification que lambda est correct */
		if (!(wLambda.size() == 3 && wLambda.cdr().car() instanceof SList)) {
			throw new LVMException(
					"*** - EVAL: wrong format for FLAMBDA. Expects (FLAMBDA SYMBOL LIST LIST|SYMBOL)");
		}

		wNFonctParams = wLambda.cdr().car().size();
		wNEffectParams = aSExpr.cdr().size();

		if (wNFonctParams > wNEffectParams) {
			throw new LVMException(String.format(
					"*** - EVAL: too few arguments given to FLAMBDA : %s",
					aSExpr.cdr()));
		}
		if (wNFonctParams < wNEffectParams) {
			throw new LVMException(String.format(
					"*** - EVAL: too many arguments given to FLAMBDA : %s",
					aSExpr.cdr()));
		}

		/* Lien entre les params fonctionels et paramètres effectifs */
		SExpr wCurFonct = wLambda.cdr().car();
		SExpr wCurEffect = aSExpr.cdr();
		Context wContext = aMachineLisp.getContext();
		for (int wI = 0; wI < wNEffectParams; wI++) {
			if (wCurFonct.car() instanceof Symbol) {
				wContext.addToContext((Symbol) wCurFonct.car(),
						wCurEffect.car());
			} else {
				throw new LVMException(
						String.format(
								"*** - FLAMBDA: functional parameter name must be a symbol, not %s",
								wCurFonct.car()));
			}
			wCurFonct = wCurFonct.cdr();
			wCurEffect = wCurEffect.cdr();
		}

		/* Exécution du flambda */
		return wLambda.cdr().cdr().car().eval(aMachineLisp);
	}

}
