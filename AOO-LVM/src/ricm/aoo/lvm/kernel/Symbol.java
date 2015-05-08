package ricm.aoo.lvm.kernel;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;

public class Symbol extends Atom {

	protected String pName;

	public Symbol(String aString) {
		this.pName = aString.toUpperCase();
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
	public boolean equals(Object aSymbol) {
		if (aSymbol instanceof Symbol) {
			return ((Symbol) aSymbol).pName.equals(this.pName);
		}
		return false;
	}

	@Override
	public SExpr eval(MachineLISP aMachineLisp) throws LVMException {
		return aMachineLisp.getContext().search(this);
	}

	@Override
	public int hashCode() {
		return this.pName.hashCode();
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public String toString() {
		return this.pName.toString();
	}
}
