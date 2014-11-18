package seed;

import java.util.ArrayList;
import java.util.List;

import universe.Cell;

public class BeaconSeedGenerator implements SeedGenerator {

	@Override
	public List<Cell> generate() {
		List<Cell> cells = new ArrayList<Cell>();
		Cell cellA = new Cell(10, 10);
		Cell cellB = new Cell(10, 11);
		Cell cellC = new Cell(11, 10);
		Cell cellD = new Cell(11, 11);
		cells.add(cellA);
		cells.add(cellB);
		cells.add(cellC);
		cells.add(cellD);

		return cells;
	}

}
