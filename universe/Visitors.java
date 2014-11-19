package universe;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import rules.CellRuleApplier;

public class Visitors {

	private Map<Cell, Visited> visitorMap = new ConcurrentHashMap<Cell, Visited>();

	public void visit(Cell cell) {
		if (visitorMap.containsKey(cell)) {
			Visited visited = visitorMap.get(cell);
			visited.visit();
		} else {
			createVisited(cell);
		}
	}

	private void createVisited(Cell cell) {
		Visited visited = new Visited();
		visited.visit();
		visitorMap.put(cell, visited);
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

	public void visitCellsWithoutNeighbours(Set<Cell> cells) {

		for (Cell cell : cells) {
			if (!visitorMap.containsKey(cell)) {
				createVisited(cell);
			}
		}
	}
}
