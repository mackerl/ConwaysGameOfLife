package universe;


import seed.BlinkerSeedGenerator;
import seed.SeedGenerator;

public class ConwaysGameOfLive {

	public static void main(String[] args) {

		Universe universe = new Universe();

		SeedGenerator seedGenerator = new BlinkerSeedGenerator();
		// seedGenerator = new BeaconSeedGenerator();
		universe.addSeedGenerator(seedGenerator);

		universe.start();

	}

}