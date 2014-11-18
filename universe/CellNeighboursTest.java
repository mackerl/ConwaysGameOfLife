package universe;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class CellNeighboursTest {

	@Test
	public void test8uniqueNeighboursGenerated() {

		Cell cell = new Cell(2, 3);
		CellNeighbours cellNeighbours = CellNeighbours.create(cell);
		List<Cell> neighbours = cellNeighbours.getNeighbours();
		Set<Cell> neighbourSet = new HashSet<Cell>();
		neighbourSet.addAll(neighbours);

		assertEquals(8, neighbourSet.size());
	}
}
