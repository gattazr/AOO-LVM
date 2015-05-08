package ricm.aoo.lvm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import ricm.aoo.lvm.kernel.SExpr;
import ricm.aoo.lvm.kernel.Symbol;

public class Context {

	public List<Map<Symbol, SExpr>> pContexts;

	/**
	 * Créé un contexte
	 */
	public Context() {
		this.pContexts = new LinkedList<Map<Symbol, SExpr>>();
		this.pContexts.add(new HashMap<Symbol, SExpr>());
	}

	/**
	 * TODO: comments
	 *
	 * @param aSymbole
	 * @param aExpr
	 */
	public void addToContext(Symbol aSymbole, SExpr aExpr) {
		this.pContexts.get(this.pContexts.size() - 1).put(aSymbole, aExpr);
	}

	/**
	 * TODO: comments
	 *
	 * @param aSymbole
	 * @param aExpr
	 */
	public void addToContextGeneral(Symbol aSymbole, SExpr aExpr) {
		this.pContexts.get(0).put(aSymbole, aExpr);
	}

	/**
	 * Retire le dernier contexte
	 */
	public void popContext() {
		this.pContexts.remove(this.pContexts.size() - 1);
	}

	/**
	 * Rajoute un contexte
	 */
	public void pushContext() {
		this.pContexts.add(new HashMap<Symbol, SExpr>());
	}

	/**
	 * recherche la valeur associé au symbole passé en paramètre dans les
	 * contextes. On recherche toujours dans le contexte le plus récent avant de
	 * remonter vers les contextes les plus anciens
	 *
	 * @param aSymbol
	 *            Symbole à rechercher dans les contextes
	 * @return la SExpr lié à ce symbole dans le contexte. lui-même si le
	 *         symbole n'est pas dans le contexte
	 *
	 */
	public SExpr search(Symbol aSymbol) {
		SExpr wSExpr;
		ListIterator<Map<Symbol, SExpr>> wIterator = this.pContexts
				.listIterator(this.pContexts.size());

		/* Itere dans chaque contexte en partant du plus récent */
		while (wIterator.hasPrevious()) {
			Map<Symbol, SExpr> wMap = wIterator.previous();
			wSExpr = wMap.get(aSymbol);
			if (wSExpr != null) {
				return wSExpr;
			}
		}

		return aSymbol;
	}
}
