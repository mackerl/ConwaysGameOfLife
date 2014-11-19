package main;

import java.util.List;

import seed.SeedFactory;
import seed.SeedGenerator;
import universe.Universe;

public class ConwaysGameOfLive {

	private final static int REFRESH_RATE = 100;
	private final static int SEEDS = 5000;

	private final static int WIDTH = 1000;
	private final static int HEIGHT = 1000;

	private final static int CELL_WIDTH = 10;
	private final static int CELL_HEIGHT = 10;

	public static void main(String[] args) {

		Universe universe = new Universe();

		defineUniverseProperties(universe);

		addSeed(universe);

		universe.start();

	}

	private static void defineUniverseProperties(Universe universe) {

		universe.setREFRESH_RATE(REFRESH_RATE);

		universe.setSize(WIDTH, HEIGHT);

		universe.setCellSize(CELL_WIDTH, CELL_HEIGHT);

	}

	private static void addSeed(Universe universe) {
		List<SeedGenerator> seed = SeedFactory.create(SEEDS);
		universe.addSeedGenerator(seed);
	}
}