package ricm.aoo.lvm.kernel;

import ricm.aoo.lvm.LVMException;

public class Symbol extends Atom {

	protected String pName;

	public Symbol(String aString) {
		this.pName = aString;
	}

	@Override
	public SExpr car() throws LVMException {
		throw new LVMException(
				"Impossible d'appeler la fonction car sur un symbole");
	}

	@Override
	public SExpr cdr() throws LVMException {
		throw new LVMException(
				"Impossible d'appeler la fonction cdr sur un symbole");
	}

	@Override
	public SExpr eval() throws LVMException {
		return null; // TODO: make function
	}

	@Override
	public String toString() {
		return this.pName.toString();
	}

}
