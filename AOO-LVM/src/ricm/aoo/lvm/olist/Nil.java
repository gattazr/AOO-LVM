package ricm.aoo.lvm.olist;

import ricm.aoo.lvm.utils.LVMException;

public class Nil extends Atom implements SList {

	@Override
	public SExpr car() throws LVMException {
		return this; // Le car de Nil est Nil
	}

	@Override
	public SExpr cdr() throws LVMException {
		return this; // Le cdr de Nil est Nil
	}

	@Override
	public SExpr eval() throws LVMException {
		return this; // TODO: make function
	}

	@Override
	public String toString() {
		return new String("()");
	}

}
