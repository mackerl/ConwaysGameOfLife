package rules;

import universe.Visited;

public class CellRuleDieOfUnderpopulation implements CellRule {

	private final int limit = 2;

	@Override
	public boolean apply(Visited cellVisited) {
		if (cellVisited.visits() < limit) {
			return true;
		}
		return false;
	};
}
