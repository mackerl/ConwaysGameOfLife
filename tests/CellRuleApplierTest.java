package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import rules.CellRuleApplier;
import universe.Cell;
import universe.Cells;
import universe.Visitors;

public class CellRuleApplierTest {

	@Test
	public void testKillTwoCells() {
		Cell A = new Cell(1, 1);
		Cell B = new Cell(1, 2);

		Cells cells = new Cells();
		cells.createCell(A).createCell(B);
		Visitors visitors = cells.visitNeighbours();

		assertEquals(12, visitors.size());

		CellRuleApplier cellRuleApplier = new CellRuleApplier(cells);

		visitors.applyRules(cellRuleApplier);

		assertTrue(cells.isEmpty());
	}
}
