package universe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VisitorsTest {

	@Test
	public void testVisit() {
		Cell cell = new Cell(1, 2);

		Visitors visitors = new Visitors();

		visitors.visit(cell);

		assertTrue(visitors.containsKey(cell));

		Visitables visited = visitors.get(cell);

		assertEquals(1, visited.visits());
	}

	@Test
	public void testGroupVisit() {
		Cell cell = new Cell(1, 2);
		Cells cells = new Cells();
		cells.createCell(cell);
		Visitors visitors = new Visitors(cells);

		CellNeighbours cellNeighbours = CellNeighbours.create(cell);

		visitors.visit(cellNeighbours);

		for (Cell cell1 : cellNeighbours.getNeighbours()) {
			assertTrue(visitors.containsKey(cell1));
			Visitables visited = visitors.get(cell1);

			assertEquals(1, visited.visits());
		}
	}
}
