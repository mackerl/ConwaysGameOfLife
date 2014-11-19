package seed;

import java.util.ArrayList;
import java.util.List;

public final class SeedFactory {

	public static List<SeedGenerator> create(int howManyOfEach) {
		List<SeedGenerator> seedGenerators = new ArrayList<SeedGenerator>();

		for (int i = 0; i < howManyOfEach; i++) {
			seedGenerators.add(new BlinkerSeedGenerator());
			seedGenerators.add(new BlockSeedGenerator());
			seedGenerators.add(new GliderSeedGenerator());
		}
		return seedGenerators;
	}
}
