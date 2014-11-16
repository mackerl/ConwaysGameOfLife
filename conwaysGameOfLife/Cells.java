package conwaysGameOfLife;

import java.util.HashSet;
import java.util.List;

public class Cells {

	final String aLiveCell = "X";
	final String deadCell = " ";

	private HashSet<Cell> cells = new HashSet<Cell>();
	private Cell maxCell = new Cell(0, 0);
	private Cell minCell = new Cell(0, 0);

	public int size() {
		return cells.size();
	}

	public Cells createCell(Cell cell) {
		if (!cells.contains(cell)) {
			cells.add(cell);
			refreshMax(cell);
			refreshMin(cell);
		}
		return this;
	}

	public void createCell(List<Cell> cells) {
		for (Cell cell : cells) {
			createCell(cell);
		}
	}

	private void refreshMax(Cell cell) {
		if (cell.x > maxCell.x) {
			maxCell.x = cell.x;
		}
		if (cell.y > maxCell.y) {
			maxCell.y = cell.y;
		}
	}

	private void refreshMin(Cell cell) {
		if (cell.x < minCell.x) {
			minCell.x = cell.x;
		}
		if (cell.y < minCell.y) {
			minCell.y = cell.y;
		}
	}

	public void killCell(Cell cell) {
		if (cells.contains(cell)) {
			cells.remove(cell);
		}
		refreshMinMax();
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

		return visitors;
	}

	public boolean isEmpty() {
		return cells.isEmpty();
	}

	void print() {
		for (int row = minCell.x; row <= maxCell.x; row++) {
			for (int col = minCell.y; col <= maxCell.y; col++) {
				Cell toTest = new Cell(row, col);
				if (contains(toTest)) {
					System.out.print(aLiveCell);
				}
				System.out.print(deadCell);
			}
			System.out.println();
		}
	}

	private void refreshMinMax() {
		minCell = new Cell(0, 0);
		maxCell = new Cell(0, 0);
		for (Cell cell : cells) {
			refreshMax(cell);
			refreshMin(cell);
		}
	}
}
