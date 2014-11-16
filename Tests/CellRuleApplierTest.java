package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import conwaysGameOfLife.Cell;
import conwaysGameOfLife.CellRuleApplier;
import conwaysGameOfLife.Cells;
import conwaysGameOfLife.Visitors;

public class CellRuleApplierTest {

	@Test
	public void testKillTwoCells() {
		Cell A = new Cell(1, 1);
		Cell B = new Cell(1, 2);

		Cells cells = new Cells();
		cells.createCell(A).createCell(B);
		Visitors visitors = cells.visitNeighbours();

		assertEquals(12, visitors.size());

		CellRuleApplier cellRuleApplier = new CellRuleApplier();
		cellRuleApplier.setCells(cells);

		visitors.applyRules(cellRuleApplier);

		assertTrue(cells.isEmpty());
	}
}
