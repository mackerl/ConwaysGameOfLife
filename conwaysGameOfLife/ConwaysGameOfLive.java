package conwaysGameOfLife;

public class ConwaysGameOfLive {

	public static void main(String[] args) {

		Universe universe = new Universe();

		SeedGenerator seedGenerator = new BlinkerSeedGenerator();
		// seedGenerator = new BeaconSeedGenerator();
		universe.setSeedGenerator(seedGenerator);

		universe.start();

	}

}