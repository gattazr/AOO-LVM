package ricm.aoo.lvm.kernel;

import ricm.aoo.lvm.LVMException;
import ricm.aoo.lvm.MachineLISP;

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
	public SExpr eval(MachineLISP aMachineLisp) throws LVMException {
		return aMachineLisp.getContext().search(this);
	}

	@Override
	public String toString() {
		return this.pName.toString();
	}

}
