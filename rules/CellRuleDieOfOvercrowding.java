package rules;

import universe.Visited;

public class CellRuleDieOfOvercrowding implements CellRule {
	private final int limit = 3;

	@Override
	public boolean apply(Visited cellVisited) {
		if (cellVisited.visits() > limit) {
			return true;
		}
		return false;
	};
}