package ricm.aoo.lvm.ofunc;

import ricm.aoo.lvm.olist.Atom;
import ricm.aoo.lvm.olist.SExpr;
import ricm.aoo.lvm.utils.LVMException;

public class Primitive extends Atom implements Fonction {

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
	public SExpr eval() throws LVMException {
		// TODO Auto-generated method stub
		return null;
	}

}
