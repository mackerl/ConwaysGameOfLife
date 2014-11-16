package conwaysGameOfLife;

public class CellRuleDieOfUnderpopulation implements CellRule {

	private final int limit = 2;

	@Override
	public boolean apply(Visited cellVisited) {
		if (cellVisited.visitors() < limit) {
			return true;
		}
		return false;
	};
}
