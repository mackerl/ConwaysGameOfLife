package conwaysGameOfLife;

public class CellRuleDieOfOvercrowding implements CellRule {
	private final int limit = 3;

	@Override
	public boolean apply(Visited cellVisited) {
		if (cellVisited.visitors() > limit) {
			return true;
		}
		return false;
	};
}
