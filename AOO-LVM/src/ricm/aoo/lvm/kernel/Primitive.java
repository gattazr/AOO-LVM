package ricm.aoo.lvm.kernel;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;

public abstract class Primitive extends Atom implements Foncteur {

	public Primitive() {
		// TODO Auto-generated constructor stub
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

}
