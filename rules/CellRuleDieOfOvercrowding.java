package rules;

import universe.Visitables;

public class CellRuleDieOfOvercrowding implements CellRule {
	private final int limit = 3;

	@Override
	public boolean apply(Visitables cellVisited) {
		if (cellVisited.visits() > limit) {
			return true;
		}
		return false;
	};
}
