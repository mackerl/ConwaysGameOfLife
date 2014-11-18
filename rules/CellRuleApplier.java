package rules;

import universe.Cell;
import universe.Cells;
import universe.Visited;

public class CellRuleApplier {

	private final Cells cells;

	public CellRuleApplier(Cells cells) {
		this.cells = cells;
	}

	private Cell cell;
	private Visited cellVisited;

	public void setCell(Cell cell) {
		this.cell = cell;
	}

	public void setCellVisited(Visited cellVisited) {
		this.cellVisited = cellVisited;
	}

	public void applyRulesOnCell() {
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
