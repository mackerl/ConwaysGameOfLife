package conwaysGameOfLife;

import java.util.HashSet;

public class Cells {

	private HashSet<Cell> cells = new HashSet<Cell>();

	public void createCell(Cell coordinate) {
		if (!cells.contains(coordinate)) {
			cells.add(coordinate);
		}
	}

	public void killCell(Cell coordinate) {
		if (cells.contains(coordinate)) {
			cells.remove(coordinate);
		}
	}

	public boolean cellAt(Cell coordinates) {
		return cells.contains(coordinates);
	}

	public Visitors visitNeighbours() {
		Visitors visitors = new Visitors();

		for (Cell cell : cells) {
			CellNeighbours cellNeighbours = CellNeighbours.create(cell);
			visitors.visit(cellNeighbours.getNeighbours());
		}

		return visitors;
	}
}
