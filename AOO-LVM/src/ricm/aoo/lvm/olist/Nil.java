package ricm.aoo.lvm.olist;

import ricm.aoo.lvm.utils.LVMException;

public class Nil extends Atom implements SList {

	@Override
	public SExpr car() throws LVMException {
		return new Nil(); // Le car de Nil est Nil
	}

	@Override
	public SExpr cdr() throws LVMException {
		return new Nil(); // Le cdr de Nil est Nil
	}

	@Override
	public String toString() {
		return new String("()");
	}

}
