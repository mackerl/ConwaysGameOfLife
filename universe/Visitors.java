package universe;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import rules.CellRuleApplier;

public class Visitors {

	private Map<Cell, Visitables> visitorMap = new ConcurrentHashMap<Cell, Visitables>();

	public void visit(Cell cell) {
		if (visitorMap.containsKey(cell)) {
			Visitables visited = visitorMap.get(cell);
			visited.visit();
		} else {
			createVisited(cell);
		}
	}

	private void createVisited(Cell cell) {
		Visitables visited = new Visitables();
		visited.visit();
		visitorMap.put(cell, visited);
	}

	void visit(List<Cell> cells) {
		for (Cell cell : cells) {
			visit(cell);
		}
	}

	public void applyRules(CellRuleApplier cellRuleApplier) {

		for (Map.Entry<Cell, Visitables> entry : visitorMap.entrySet()) {
			cellRuleApplier.setCell(entry.getKey());
			cellRuleApplier.setCellVisited(entry.getValue());
			cellRuleApplier.applyRulesOnCell();
		}
	}

	public Visitables get(Cell cell) {
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
