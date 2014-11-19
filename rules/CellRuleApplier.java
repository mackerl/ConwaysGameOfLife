package rules;

import universe.Cell;
import universe.Cells;
import universe.Visited;
import universe.Visitors;

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
		CellRule dieOfUnderpopulation = new CellRuleDieOfUnderpopulation();
		if (dieOfUnderpopulation.apply(cellVisited)) {
			cells.killCell(cell);
		}
	}

	private void applyOverCrowdingRule() {
		CellRule dieOfOvercrowding = new CellRuleDieOfOvercrowding();

		if (dieOfOvercrowding.apply(cellVisited)) {
			cells.killCell(cell);
		}
	}

	public void applyDeadCellRules() {
		CellRule borneCellFromPopulationRule = new CellRuleBornCellFromPopulation();
		if (borneCellFromPopulationRule.apply(cellVisited)) {
			cells.createCell(cell);
		}
	}

	public void applyRules() {
		Visitors visitors = cells.visitNeighbours();
		visitors.applyRules(this);

	}

}
