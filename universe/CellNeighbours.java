package universe;

import java.util.ArrayList;
import java.util.List;

public class CellNeighbours {

	private List<Cell> neighbours = new ArrayList<Cell>();
	private static CellNeighbours coordinateNeighbours;

	public List<Cell> getNeighbours() {
		return neighbours;
	}

	public static CellNeighbours create(Cell cell) {

		coordinateNeighbours = new CellNeighbours();

		addCellNeighbours(cell);

		return coordinateNeighbours;
	}

	private static void addCellNeighbours(Cell cell) {
		for (int x = cell.x - 1; x <= cell.x + 1; x++) {
			for (int y = cell.y - 1; y <= cell.y + 1; y++) {
				Cell toInsert = new Cell(x, y);
				if (!toInsert.equals(cell)) {
					coordinateNeighbours.neighbours.add(toInsert);
				}
			}
		}
	}
}
