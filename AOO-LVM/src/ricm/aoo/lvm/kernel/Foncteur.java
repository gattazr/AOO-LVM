package ricm.aoo.lvm.kernel;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;

public interface Foncteur {

	/**
	 * TODO: comments
	 * @param aMachineLisp TODO
	 * @param aSExpr
	 * 
	 * @return
	 * @throws LVMException
	 */
	SExpr exec(MachineLISP aMachineLisp, SExpr aSExpr) throws LVMException;

}

/*
 * 1 -> Evaluer foncteurs 2 -> Création de la liste des arguments 3 ->
 * Application fonctionnelles : - Liaison des parammètres fonctionnel et params
 * applicatifs - Evaluation du corps de la fonctions - Destructions des laisons
 */