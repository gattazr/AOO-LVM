package ricm.aoo.lvm;

import ricm.aoo.lvm.kernel.Symbol;
import ricm.aoo.lvm.primit.Apply;
import ricm.aoo.lvm.primit.Atom;
import ricm.aoo.lvm.primit.Car;
import ricm.aoo.lvm.primit.Cdr;
import ricm.aoo.lvm.primit.Cond;
import ricm.aoo.lvm.primit.Cons;
import ricm.aoo.lvm.primit.De;
import ricm.aoo.lvm.primit.Df;
import ricm.aoo.lvm.primit.Eq;
import ricm.aoo.lvm.primit.Eval;
import ricm.aoo.lvm.primit.Print;
import ricm.aoo.lvm.primit.Quit;
import ricm.aoo.lvm.primit.Scope;
import ricm.aoo.lvm.primit.Set;
import ricm.aoo.lvm.primit.TopLevel;

public class MachineLISP {

	private Context pContext = new Context();

	public MachineLISP() {
		/* Initialisation des primitives du langages */
		this.pContext.addToContextGeneral(new Symbol("apply"), new Apply());
		this.pContext.addToContextGeneral(new Symbol("atom"), new Atom());
		this.pContext.addToContextGeneral(new Symbol("car"), new Car());
		this.pContext.addToContextGeneral(new Symbol("cdr"), new Cdr());
		this.pContext.addToContextGeneral(new Symbol("cond"), new Cond());
		this.pContext.addToContextGeneral(new Symbol("cons"), new Cons());
		this.pContext.addToContextGeneral(new Symbol("de"), new De());
		this.pContext.addToContextGeneral(new Symbol("df"), new Df());
		this.pContext.addToContextGeneral(new Symbol("eq"), new Eq());
		this.pContext.addToContextGeneral(new Symbol("eval"), new Eval());
		this.pContext.addToContextGeneral(new Symbol("print"), new Print());
		this.pContext.addToContextGeneral(new Symbol("quit"), new Quit());
		this.pContext.addToContextGeneral(new Symbol("scope"), new Scope());
		this.pContext.addToContextGeneral(new Symbol("set"), new Set());
		this.pContext.addToContextGeneral(new Symbol("toplevel"),
				new TopLevel());
	}

	public Context getContext() {
		return pContext;
	}

}
