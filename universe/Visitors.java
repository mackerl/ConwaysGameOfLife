package universe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rules.CellRuleApplier;

public class Visitors {

	private Map<Cell, Visited> visitorMap = new HashMap<Cell, Visited>();

	public void visit(Cell cell) {
		if (visitorMap.containsKey(cell)) {
			Visited visited = visitorMap.get(cell);
			visited.visit();
		} else {
			Visited visited = new Visited();
			visited.visit();
			visitorMap.put(cell, visited);
		}
	}

	void visit(List<Cell> cells) {
		for (Cell cell : cells) {
			visit(cell);
		}
	}

	public void applyRules(CellRuleApplier cellRuleApplier) {

		for (Map.Entry<Cell, Visited> entry : visitorMap.entrySet()) {
			cellRuleApplier.setCell(entry.getKey());
			cellRuleApplier.setCellVisited(entry.getValue());
			cellRuleApplier.applyRulesOnCell();
		}
	}

	public Visited get(Cell cell) {
		return visitorMap.get(cell);
	}

	public boolean containsKey(Cell cell) {
		return visitorMap.containsKey(cell);
	}

	public int size() {
		return visitorMap.size();
	}

	public void visit(CellNeighbours cellNeighbours) {
		visit(cellNeighbours.getNeighbours());
	}
}
