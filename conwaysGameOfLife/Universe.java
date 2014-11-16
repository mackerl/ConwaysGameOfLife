package conwaysGameOfLife;

public class Universe {

	private final Cells cells = new Cells();
	private Visitors visitors = null;
	private final CellRuleApplier cellRuleApplier = new CellRuleApplier();

	public void tick() {
		visitNeighbours();
		applyRules();
	}

	private void visitNeighbours() {
		visitors = cells.visitNeighbours();
	}

	private void applyRules() {
		cellRuleApplier.setCells(cells);
		cellRuleApplier.setVisitors(visitors);
		cellRuleApplier.apply();
	}

}
