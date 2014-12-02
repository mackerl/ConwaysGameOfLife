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

	@Test
	public void threeCellsGrow() {
		Cell A = new Cell(1, 1);
		Cell B = new Cell(1, 2);
		Cell C = new Cell(2, 2);

		Cells cells = new Cells();
		cells.createCell(A).createCell(B).createCell(C);
		Visitors visitors = cells.visitNeighbours();

		assertEquals(15, visitors.size());

		CellRuleApplier cellRuleApplier = new CellRuleApplier(cells);

		cellRuleApplier.applyRules();

		assertEquals(cells.size(), 4);
	}

	@Test
	public void fourCellsStay() {
		Cell A = new Cell(1, 1);
		Cell B = new Cell(1, 2);
		Cell C = new Cell(2, 2);
		Cell D = new Cell(2, 1);

		Cells cells = new Cells();
		cells.createCell(A).createCell(B).createCell(C).createCell(D);
		Visitors visitors = cells.visitNeighbours();

		assertEquals(16, visitors.size());

		CellRuleApplier cellRuleApplier = new CellRuleApplier(cells);

		cellRuleApplier.applyRules();

		assertEquals(cells.size(), 4);
	}

	@Test
	public void fiveCellsDie() {
		Cell A = new Cell(1, 1);
		Cell B = new Cell(1, 2);
		Cell C = new Cell(2, 2);
		Cell D = new Cell(2, 1);
		Cell E = new Cell(2, 3);

		Cells cells = new Cells();
		cells.createCell(A).createCell(B).createCell(C).createCell(D)
				.createCell(E);
		Visitors visitors = cells.visitNeighbours();

		assertEquals(19, visitors.size());

		CellRuleApplier cellRuleApplier = new CellRuleApplier(cells);

		cellRuleApplier.applyRules();
		cellRuleApplier.applyRules();
		cellRuleApplier.applyRules();
		cellRuleApplier.applyRules();

		assertEquals(cells.size(), 0);
	}
}
