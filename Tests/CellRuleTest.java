package Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import conwaysGameOfLife.CellRuleBornCellFromPopulation;
import conwaysGameOfLife.CellRuleDieOfOvercrowding;
import conwaysGameOfLife.CellRuleDieOfUnderpopulation;
import conwaysGameOfLife.Visited;

public class CellRuleTest {

	@Test
	public void BornCellFromThreeNeighbours() {
		Visited cellVisited = new Visited();
		int expectedVisitors = 3;

		cellVisited.visit(expectedVisitors);
		CellRuleBornCellFromPopulation cellRuleBornCellFromPopulation = new CellRuleBornCellFromPopulation();

		// Precondition
		assertSame(expectedVisitors, cellVisited.visitors());

		boolean createCell = cellRuleBornCellFromPopulation.apply(cellVisited);
		assertTrue(createCell);

	}

	@Test
	public void KillCellWithLessThanTwoNeighbours() {
		Visited cellVisited = new Visited();
		int expectedVisitors = 0;

		cellVisited.visit(expectedVisitors);
		CellRuleDieOfUnderpopulation cellRuleDieOfUnderpopulation = new CellRuleDieOfUnderpopulation();

		// Precondition
		assertSame(expectedVisitors, cellVisited.visitors());

		boolean dieOfUnderPopulation = cellRuleDieOfUnderpopulation
				.apply(cellVisited);
		assertTrue(dieOfUnderPopulation);

		cellVisited.visit();
		dieOfUnderPopulation = cellRuleDieOfUnderpopulation.apply(cellVisited);
		assertTrue(dieOfUnderPopulation);
	}

	@Test
	public void KillCellWithMoreThanTwoNeighbours() {
		Visited cellVisited = new Visited();
		int expectedVisitors = 4;

		CellRuleDieOfOvercrowding cellRuleDieOfOvercrowding = new CellRuleDieOfOvercrowding();

		cellVisited.visit(expectedVisitors);
		// Precondition
		assertSame(expectedVisitors, cellVisited.visitors());

		boolean dieOfOvercrowding = cellRuleDieOfOvercrowding
				.apply(cellVisited);

		assertTrue(dieOfOvercrowding);
	}

	@Test
	public void DoNotCreateCellWithOutThreeNeighbours() {
		Visited cellVisited = new Visited();
		int expectedVisitors = 2;

		cellVisited.visit(expectedVisitors);
		CellRuleBornCellFromPopulation cellRuleBornCellFromPopulation = new CellRuleBornCellFromPopulation();

		// Precondition
		assertSame(expectedVisitors, cellVisited.visitors());

		boolean createCell = cellRuleBornCellFromPopulation.apply(cellVisited);
		assertFalse(createCell);

		// 4 neighbours
		cellVisited.visit(expectedVisitors);
		createCell = cellRuleBornCellFromPopulation.apply(cellVisited);
		assertFalse(createCell);
	}

}
