package conwaysGameOfLife;

import java.util.Map;

public class CellRuleApplier {

	private Visitors visitors;
	private Cells cells;
	private Cell cell;
	private Visited visited;

	public void setVisitors(Visitors visitors) {
		this.visitors = visitors;
	}

	public void setCells(Cells cells) {
		this.cells = cells;
	}

	public void apply() {

		Map<Cell, Visited> visitor = visitors.getVisitors();

		for (Map.Entry<Cell, Visited> entry : visitor.entrySet()) {
			cell = entry.getKey();
			visited = entry.getValue();
			if (cells.cellAt(cell)) {
				applyLiveCellRules(visited);
			}
			applyDeadCellRules(visited);
		}

	}

	public void applyLiveCellRules(Visited visited) {
	}

	public void applyDeadCellRules(Visited visited) {
		CellRuleBornCellFromPopulation borneCellFromPopulationRule = new CellRuleBornCellFromPopulation();
		if (borneCellFromPopulationRule.apply(visited)) {
			cells.createCell(cell);
		}
	}

}
