package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import seed.BlinkerSeedGenerator;
import seed.SeedGenerator;
import universe.Cell;
import universe.CellNeighbours;
import universe.Cells;
import universe.Visited;
import universe.Visitors;

public class CellsTest {

	@Test
	public void testCellInsert() {

		Cell cell = new Cell(1, 2);
		Cells cells = new Cells();

		cells.createCell(cell);

		assertTrue(cells.contains(cell));

	}

	@Test
	public void testCellInsertWithBlinkerSeedGenerator() {
		SeedGenerator seedGenerator = new BlinkerSeedGenerator();
		Cells cells = new Cells();

		List<Cell> seed = seedGenerator.generate();
		assertEquals(3, seed.size());

		cells.createCell(seed);

		for (Cell cell : seed) {
			assertTrue(cells.contains(cell));
		}

	}

	@Test
	public void testVisitNeighbours() {
		Cell cell = new Cell(1, 2);
		Cells cells = new Cells();

		cells.createCell(cell);

		Visitors visitors = cells.visitNeighbours();
		assertEquals(8, visitors.size());

		CellNeighbours cellNeighbours = CellNeighbours.create(cell);
		List<Cell> neighbours = cellNeighbours.getNeighbours();

		for (Cell neighbour : neighbours) {
			assertTrue(visitors.containsKey(neighbour));
			Visited visited = visitors.get(neighbour);
			assertEquals(1, visited.visits());
		}

	}
}
