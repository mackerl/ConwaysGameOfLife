package universe;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import rules.CellRuleApplier;

public class Visitors {

	private Map<Cell, Visitables> visitorMap = new ConcurrentHashMap<Cell, Visitables>();

	public Visitors() {

	}

	public Visitors(Cells cells) {
		for (Cell cell : cells.aliveCells) {
			createVisitables(cell);
		}
	}

	public void visit(Cell cell) {
		if (visitorMap.containsKey(cell)) {
			Visitables visitable = visitorMap.get(cell);
			visitable.visit();
		} else {
			createVisitables(cell);
			visit(cell);
		}
	}

	private void createVisitables(Cell cell) {
		Visitables visitable = new Visitables();
		visitorMap.put(cell, visitable);
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
}
