package rules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import universe.Cell;
import universe.Cells;
import universe.Visitors;

public class CellRuleApplierTest {

	@Test
	public void killTwoCells() {
		Cell A = new Cell(1, 1);
		Cell B = new Cell(1, 2);

		Cells cells = new Cells();
		cells.createCell(A).createCell(B);
		Visitors visitors = cells.visitNeighbours();

		assertEquals(12, visitors.size());

		CellRuleApplier cellRuleApplier = new CellRuleApplier(cells);

		cellRuleApplier.applyRules();

		assertTrue(cells.isEmpty());
	}

	@Test
	public void killSingleCell() {
		Cell A = new Cell(1, 1);

		Cells cells = new Cells();
		cells.createCell(A);
		Visitors visitors = cells.visitNeighbours();

		assertEquals(9, visitors.size());

		CellRuleApplier cellRuleApplier = new CellRuleApplier(cells);

		cellRuleApplier.applyRules();

		assertTrue(cells.isEmpty());
	}
}
