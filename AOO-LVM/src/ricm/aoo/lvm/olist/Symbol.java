package ricm.aoo.lvm.olist;

import ricm.aoo.lvm.utils.LVMException;

public class Symbol extends Atom {

	private String pSymbol;

	public Symbol(String aString) {
		this.pSymbol = aString;
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
	public String toString() {
		return this.pSymbol.toString();
	}

}
