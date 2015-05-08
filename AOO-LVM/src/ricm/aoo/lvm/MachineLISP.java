package ricm.aoo.lvm;

import ricm.aoo.lvm.kernel.Symbol;
import ricm.aoo.lvm.subr.Car;
import ricm.aoo.lvm.subr.Cdr;

public class MachineLISP {

	public Context pContext = new Context();

	public MachineLISP() {
		/* Initialisation du contexte ici */
		this.pContext.addToContextGeneral(new Symbol("car"), new Car());
		this.pContext.addToContextGeneral(new Symbol("cdr"), new Cdr());
	}

	public Context getContext() {
		return pContext;
	}

}
