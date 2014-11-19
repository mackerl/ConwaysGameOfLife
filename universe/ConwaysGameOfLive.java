package universe;

import seed.SeedFactory;

public class ConwaysGameOfLive {

	public static void main(String[] args) {

		Universe universe = new Universe();

		universe.addSeedGenerator(SeedFactory.create(100));

		universe.start();

	}
}