package universe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import seed.BlinkerSeedGenerator;
import seed.SeedGenerator;

public class CellsTest {

	@Test
	public void testCellInsert() {

		Cell cell = new Cell(1, 2);
		Cells cells = new Cells();

		cells.createCell(cell);

		assertTrue(cells.contains(cell));

		assertEquals(cells.size(), 1);

	}

	@Test
	public void testCellOff() {

		Cell A = new Cell(1, 2);
		Cell B = new Cell(1, 1, 0, 1);

		assertTrue(A.equals(B));

	}

	@Test
	public void cellConstruction() {

		Cell A = new Cell();
		Cell B = new Cell(0, 0, 0, 0);
		Cell C = new Cell(0, 0);

		assertTrue(A.equals(B));
		assertTrue(A.equals(C));

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
		assertEquals(9, visitors.size());

		CellNeighbours cellNeighbours = CellNeighbours.create(cell);
		List<Cell> neighbours = cellNeighbours.getNeighbours();

		for (Cell neighbour : neighbours) {
			assertTrue(visitors.containsKey(neighbour));
			Visitables visited = visitors.get(neighbour);
			assertEquals(1, visited.visits());
		}

	}

	@Test
	public void testGetMax() {
		Cell a = new Cell(1, 2);
		Cell b = new Cell(2, 1);

		Cells cells = new Cells();

		cells.createCell(b).createCell(a);

		Cell max = new Cell(2, 2);
		Cell calculatedMax = cells.getMax();

		assertTrue(max.equals(calculatedMax));

		Cell newMax = new Cell(4, 5);
		cells.createCell(newMax);
		Cell calculatedNewMax = cells.getMax();

		assertTrue(newMax.equals(calculatedNewMax));
	}

	@Test
	public void testGetMin() {
		Cell a = new Cell(1, 2);
		Cell b = new Cell(2, 1);

		Cells cells = new Cells();

		cells.createCell(b).createCell(a);

		Cell min = new Cell(1, 1);
		Cell calculatedMin = cells.getMin();

		assertTrue(min.equals(calculatedMin));

		Cell newMin = new Cell(0, 5);
		cells.createCell(newMin);
		Cell calculatedNewMin = cells.getMin();

		assertTrue(newMin.equals(calculatedNewMin));
	}
}
