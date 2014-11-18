package universe;

import seed.BlinkerSeedGenerator;
import seed.BlockSeedGenerator;
import seed.GliderSeedGenerator;
import seed.SeedGenerator;

public class ConwaysGameOfLive {

	public static void main(String[] args) {

		Universe universe = new Universe();

		SeedGenerator blinkderSeed = new BlinkerSeedGenerator();
		SeedGenerator beaconSeed = new BlockSeedGenerator();
		SeedGenerator gliderGun = new GliderSeedGenerator();
		universe.addSeedGenerator(blinkderSeed);
		universe.addSeedGenerator(beaconSeed);
		universe.addSeedGenerator(gliderGun);

		universe.start();

	}

}