package conwaysGameOfLife;

import java.util.ArrayList;
import java.util.List;

public class BeaconSeedGenerator implements SeedGenerator {

	@Override
	public List<Cell> generate() {
		List<Cell> cells = new ArrayList<Cell>();
		Cell cellA = new Cell(1, 1);
		Cell cellB = new Cell(1, 2);
		Cell cellC = new Cell(2, 1);
		Cell cellD = new Cell(2, 2);
		cells.add(cellA);
		cells.add(cellB);
		cells.add(cellC);
		cells.add(cellD);

		return cells;
	}

}
