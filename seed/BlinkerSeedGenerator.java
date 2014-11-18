package seed;

import java.util.ArrayList;
import java.util.List;

import universe.Cell;

public class BlinkerSeedGenerator implements SeedGenerator {

	@Override
	public List<Cell> generate() {
		List<Cell> cells = new ArrayList<Cell>();
		Cell cellA = new Cell(2, 3);
		Cell cellB = new Cell(3, 3);
		Cell cellC = new Cell(4, 3);

		cells.add(cellA);
		cells.add(cellB);
		cells.add(cellC);
		return cells;
	}

}
