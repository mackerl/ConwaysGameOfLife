package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import conwaysGameOfLife.Cell;
import conwaysGameOfLife.CellNeighbours;
import conwaysGameOfLife.Visited;
import conwaysGameOfLife.Visitors;

public class VisitorsTest {

	@Test
	public void testVisit() {
		Visitors visitors = new Visitors();
		Cell cell = new Cell(1, 2);

		visitors.visit(cell);

		assertTrue(visitors.containsKey(cell));

		Visited visited = visitors.get(cell);

		assertEquals(1, visited.visitors());
	}

	@Test
	public void testGroupVisit() {
		Visitors visitors = new Visitors();
		Cell cell = new Cell(1, 2);

		CellNeighbours cellNeighbours = CellNeighbours.create(cell);

		visitors.visit(cellNeighbours);

		for (Cell cell1 : cellNeighbours.getNeighbours()) {
			assertTrue(visitors.containsKey(cell1));
			Visited visited = visitors.get(cell1);

			assertEquals(1, visited.visitors());
		}
	}
}
