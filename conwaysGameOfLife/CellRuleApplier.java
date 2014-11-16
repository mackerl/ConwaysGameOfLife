package conwaysGameOfLife;

public class CellRuleApplier {

	private Cells cells;

	private Cell cell;
	private Visited cellVisited;

	public void setCell(Cell cell) {
		this.cell = cell;
	}

	public void setCellVisited(Visited cellVisited) {
		this.cellVisited = cellVisited;
	}

	public void setCells(Cells cells) {
		this.cells = cells;
	}

	void applyRulesOnCell() {
		if (cells.contains(cell)) {
			applyLiveCellRules();
		} else {
			applyDeadCellRules();
		}
	}

	public void applyLiveCellRules() {
		applyOverCrowdingRule();
		applyUnderPopulationRule();
	}

	private void applyUnderPopulationRule() {
		CellRuleDieOfUnderpopulation dieOfUnderpopulation = new CellRuleDieOfUnderpopulation();
		if (dieOfUnderpopulation.apply(cellVisited)) {
			cells.killCell(cell);
		}
	}

	private void applyOverCrowdingRule() {
		CellRuleDieOfOvercrowding dieOfOvercrowding = new CellRuleDieOfOvercrowding();

		if (dieOfOvercrowding.apply(cellVisited)) {
			cells.killCell(cell);
		}
	}

	public void applyDeadCellRules() {
		CellRuleBornCellFromPopulation borneCellFromPopulationRule = new CellRuleBornCellFromPopulation();
		if (borneCellFromPopulationRule.apply(cellVisited)) {
			cells.createCell(cell);
		}
	}

}
