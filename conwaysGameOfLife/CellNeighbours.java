package conwaysGameOfLife;

import java.util.ArrayList;
import java.util.List;

public class CellNeighbours {

	private List<Cell> neighbours = new ArrayList<Cell>();

	public List<Cell> getNeighbours() {
		return neighbours;
	}

	public static CellNeighbours create(Cell coordinate) {
		CellNeighbours coordinateNeighbours = new CellNeighbours();
		for (int x = coordinate.x - 1; x <= coordinate.x + 1; x++) {
			for (int y = coordinate.y - 1; y <= coordinate.y + 1; y++) {
				Cell toInsert = new Cell(x, y);
				if (!toInsert.equals(toInsert)) {
					coordinateNeighbours.neighbours.add(toInsert);
				}
			}
		}

		return coordinateNeighbours;
	}
}
