package universe;

import java.util.List;

import seed.SeedFactory;
import seed.SeedGenerator;

public class ConwaysGameOfLive {

	private final static int REFRESH_RATE = 100;
	private final static int SEEDS = 500;
	private final static int WIDTH = 1000;
	private final static int HEIGHT = 1000;

	public static void main(String[] args) {

		List<SeedGenerator> seed = SeedFactory.create(SEEDS);

		Universe universe = new Universe();

		defineUniverseProperties(seed, universe);

		universe.start();

	}

	private static void defineUniverseProperties(List<SeedGenerator> seed,
			Universe universe) {
		universe.addSeedGenerator(seed);
		universe.setREFRESH_RATE(REFRESH_RATE);
		universe.setSize(WIDTH, HEIGHT);
	}
}