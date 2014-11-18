package universe;

import seed.BeaconSeedGenerator;
import seed.BlinkerSeedGenerator;
import seed.SeedGenerator;

public class ConwaysGameOfLive {

	public static void main(String[] args) {

		Universe universe = new Universe();

		SeedGenerator blinkderSeed = new BlinkerSeedGenerator();
		SeedGenerator beaconSeed = new BeaconSeedGenerator();
		universe.addSeedGenerator(blinkderSeed);
		universe.addSeedGenerator(beaconSeed);

		universe.start();

	}

}