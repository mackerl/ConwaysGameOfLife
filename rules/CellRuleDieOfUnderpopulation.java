package rules;

import universe.Visitables;

public class CellRuleDieOfUnderpopulation implements CellRule {

	private final int limit = 2;

	@Override
	public boolean apply(Visitables cellVisited) {
		if (cellVisited.visits() < limit) {
			return true;
		}
		return false;
	};
}
