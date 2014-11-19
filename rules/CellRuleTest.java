package rules;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import universe.Visitables;

public class CellRuleTest {

	@Test
	public void BornCellFromThreeNeighbours() {
		Visitables cellVisited = new Visitables();
		int expectedVisitors = 3;

		cellVisited.visit(expectedVisitors);
		CellRuleBornCellFromPopulation cellRuleBornCellFromPopulation = new CellRuleBornCellFromPopulation();

		// Precondition
		assertSame(expectedVisitors, cellVisited.visits());

		boolean createCell = cellRuleBornCellFromPopulation.apply(cellVisited);
		assertTrue(createCell);

	}

	@Test
	public void KillCellWithLessThanTwoNeighbours() {
		Visitables cellVisited = new Visitables();
		int expectedVisitors = 0;

		cellVisited.visit(expectedVisitors);
		CellRuleDieOfUnderpopulation cellRuleDieOfUnderpopulation = new CellRuleDieOfUnderpopulation();

		// Precondition
		assertSame(expectedVisitors, cellVisited.visits());

		boolean dieOfUnderPopulation = cellRuleDieOfUnderpopulation
				.apply(cellVisited);
		assertTrue(dieOfUnderPopulation);

		cellVisited.visit();
		dieOfUnderPopulation = cellRuleDieOfUnderpopulation.apply(cellVisited);
		assertTrue(dieOfUnderPopulation);
	}

	@Test
	public void KillCellWithMoreThanTwoNeighbours() {
		Visitables cellVisited = new Visitables();
		int expectedVisitors = 4;

		CellRuleDieOfOvercrowding cellRuleDieOfOvercrowding = new CellRuleDieOfOvercrowding();

		cellVisited.visit(expectedVisitors);
		// Precondition
		assertSame(expectedVisitors, cellVisited.visits());

		boolean dieOfOvercrowding = cellRuleDieOfOvercrowding
				.apply(cellVisited);

		assertTrue(dieOfOvercrowding);
	}

	@Test
	public void DoNotCreateCellWithOutThreeNeighbours() {
		Visitables cellVisited = new Visitables();
		int expectedVisitors = 2;

		cellVisited.visit(expectedVisitors);
		CellRuleBornCellFromPopulation cellRuleBornCellFromPopulation = new CellRuleBornCellFromPopulation();

		// Precondition
		assertSame(expectedVisitors, cellVisited.visits());

		boolean createCell = cellRuleBornCellFromPopulation.apply(cellVisited);
		assertFalse(createCell);

		// 4 neighbours
		cellVisited.visit(expectedVisitors);
		createCell = cellRuleBornCellFromPopulation.apply(cellVisited);
		assertFalse(createCell);
	}

}
