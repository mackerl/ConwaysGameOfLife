package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import universe.Cell;
import universe.CellNeighbours;
import universe.Visited;
import universe.Visitors;

public class VisitorsTest {

	@Test
	public void testVisit() {
		Visitors visitors = new Visitors();
		Cell cell = new Cell(1, 2);

		visitors.visit(cell);

		assertTrue(visitors.containsKey(cell));

		Visited visited = visitors.get(cell);

		assertEquals(1, visited.visits());
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

			assertEquals(1, visited.visits());
		}
	}
}
