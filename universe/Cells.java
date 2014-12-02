package universe;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Cells {

	Set<Cell> aliveCells = Collections
			.newSetFromMap(new ConcurrentHashMap<Cell, Boolean>());

	public void createCell(List<Cell> cells) {
		for (Cell cell : cells) {
			createCell(cell);
		}
	}

	public Cells createCell(Cell cell) {
		if (!aliveCells.contains(cell)) {
			aliveCells.add(cell);
		}
		return this;
	}

	public void killCell(Cell cell) {
		if (aliveCells.contains(cell)) {
			aliveCells.remove(cell);
		}
	}

	public Visitors visitNeighbours() {
		Visitors visitors = new Visitors(this);

		for (Cell cell : aliveCells) {
			CellNeighbours cellNeighbours = CellNeighbours.create(cell);
			visitors.visit(cellNeighbours);
		}

		return visitors;
	}

	public int size() {
		return aliveCells.size();
	}

	public boolean isEmpty() {
		return aliveCells.isEmpty();
	}

	public boolean contains(Cell cell) {
		return aliveCells.contains(cell);
	}

	Cell getMax() {
		Cell maxCell = null;
		for (Cell cell : aliveCells) {
			if (maxCell == null) {
				maxCell = cell;
				continue;
			}
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
		Cell minCell = null;
		for (Cell cell : aliveCells) {
			if (minCell == null) {
				minCell = cell;
				continue;
			}
			if (cell.x < minCell.x) {
				minCell.x = cell.x;
			}
			if (cell.y < minCell.y) {
				minCell.y = cell.y;
			}
		}
		return minCell;
	}

}
