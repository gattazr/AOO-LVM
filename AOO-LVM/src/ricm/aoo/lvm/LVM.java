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
import ricm.aoo.lvm.primit.Eprogn;
import ricm.aoo.lvm.primit.Eq;
import ricm.aoo.lvm.primit.Eval;
import ricm.aoo.lvm.primit.Explode;
import ricm.aoo.lvm.primit.Implode;
import ricm.aoo.lvm.primit.List;
import ricm.aoo.lvm.primit.Load;
import ricm.aoo.lvm.primit.Print;
import ricm.aoo.lvm.primit.Quit;
import ricm.aoo.lvm.primit.Scope;
import ricm.aoo.lvm.primit.Set;
import ricm.aoo.lvm.primit.TopLevel;

public class LVM {

	public static void main(String[] aArgs) {
		LVM wLVM = new LVM();
		MachineLISP wMachineLISP = wLVM.initEnv();
		try {
			/* Charge quelques fonctions classiques */
			Reader.read("(load ressources/lisp.txt)").eval(wMachineLISP);
			Reader.read("(toplevel)").eval(wMachineLISP);
		} catch (LVMException aException) {
			Console.println(aException.getMessage());
			Console.printStack(aException);
		}
	}

	public LVM() {
	}

	public MachineLISP initEnv() {
		MachineLISP wMachine = new MachineLISP();

		/* Initialisation des primitives du langages */
		Context wContext = wMachine.getContext();
		wContext.addToContextGeneral(new Symbol("apply"), new Apply());
		wContext.addToContextGeneral(new Symbol("atom"), new Atom());
		wContext.addToContextGeneral(new Symbol("car"), new Car());
		wContext.addToContextGeneral(new Symbol("cdr"), new Cdr());
		wContext.addToContextGeneral(new Symbol("cond"), new Cond());
		wContext.addToContextGeneral(new Symbol("cons"), new Cons());
		wContext.addToContextGeneral(new Symbol("de"), new De());
		wContext.addToContextGeneral(new Symbol("df"), new Df());
		wContext.addToContextGeneral(new Symbol("eprogn"), new Eprogn());
		wContext.addToContextGeneral(new Symbol("eq"), new Eq());
		wContext.addToContextGeneral(new Symbol("eval"), new Eval());
		wContext.addToContextGeneral(new Symbol("explode"), new Explode());
		wContext.addToContextGeneral(new Symbol("implode"), new Implode());
		wContext.addToContextGeneral(new Symbol("list"), new List());
		wContext.addToContextGeneral(new Symbol("load"), new Load());
		wContext.addToContextGeneral(new Symbol("print"), new Print());
		wContext.addToContextGeneral(new Symbol("quit"), new Quit());
		wContext.addToContextGeneral(new Symbol("scope"), new Scope());
		wContext.addToContextGeneral(new Symbol("set"), new Set());
		wContext.addToContextGeneral(new Symbol("toplevel"), new TopLevel());

		return wMachine;
	}

	public void quit() {
		Console.println("Goodbye");
	}

}
