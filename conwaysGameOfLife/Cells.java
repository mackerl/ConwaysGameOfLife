package conwaysGameOfLife;

import java.util.HashSet;

public class Cells {

	private HashSet<Coordinate> cells = new HashSet<Coordinate>();

	public void createCell(Coordinate coordinate) {
		if (!cells.contains(coordinate)) {
			cells.add(coordinate);
		}
	}

	public void killCell(Coordinate coordinate) {
		if (cells.contains(coordinate)) {
			cells.remove(coordinate);
		}
	}

	public boolean cellAt(Coordinate coordinates) {
		return cells.contains(coordinates);
	}

	public Visitors visitNeighbours() {
		Visitors visitors = new Visitors();
		
		for()

		return visitors;
	}
}
