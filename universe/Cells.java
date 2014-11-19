package universe;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Cells {

	private Set<Cell> cells = Collections
			.newSetFromMap(new ConcurrentHashMap<Cell, Boolean>());

	public int size() {
		return cells.size();
	}

	public Cells createCell(Cell cell) {
		if (!cells.contains(cell)) {
			cells.add(cell);
		}
		return this;
	}

	public void createCell(List<Cell> cells) {
		for (Cell cell : cells) {
			createCell(cell);
		}
	}

	Cell getMax() {
		Cell maxCell = new Cell();
		for (Cell cell : cells) {
			if (cell.x > maxCell.x) {
				maxCell.x = cell.x;
			}
			if (cell.y > maxCell.y) {
				maxCell.y = cell.y;
			}
		}
		return maxCell;
	}

	Cell getMin() {
		Cell minCell = new Cell();
		for (Cell cell : cells) {
			if (cell.x < minCell.x) {
				minCell.x = cell.x;
			}
			if (cell.y < minCell.y) {
				minCell.y = cell.y;
			}
		}
		return minCell;
	}

	public void killCell(Cell cell) {
		if (cells.contains(cell)) {
			cells.remove(cell);
		}
	}

	public boolean contains(Cell cell) {
		return cells.contains(cell);
	}

	public Visitors visitNeighbours() {
		Visitors visitors = new Visitors();

		for (Cell cell : cells) {
			CellNeighbours cellNeighbours = CellNeighbours.create(cell);
			visitors.visit(cellNeighbours);
		}
		visitors.visitCellsWithoutNeighbours(cells);

		return visitors;
	}

	public boolean isEmpty() {
		return cells.isEmpty();
	}
}
