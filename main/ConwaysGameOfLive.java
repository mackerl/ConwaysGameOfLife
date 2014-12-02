package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import seed.LifFileSeedGenerator;
import seed.SeedFactory;
import seed.SeedGenerator;
import universe.Universe;

public class ConwaysGameOfLive {

	private final int REFRESH_RATE = 100;;

	private final int WIDTH = 1000;
	private final int HEIGHT = 1000;
	private final int CELL_WIDTH = 10;
	private final int CELL_HEIGHT = 10;

	private final int SEEDS = 50;

	private boolean readFromFile = true;
	private final File lifFile = new File("lifs/PUFPUF.LIF");

	private boolean readFromFolder = false;
	private final File LifFileFolder = new File("lifs");

	public static void main(String[] args) {
		ConwaysGameOfLive conwaysGameOfLive = new ConwaysGameOfLive();
		conwaysGameOfLive.start();
	}

	private final Universe universe = new Universe();

	private void start() {

		defineUniverseProperties(universe);

		addSeed(universe);

		// universe.start();
	}

	private void defineUniverseProperties(Universe universe) {

		universe.setREFRESH_RATE(REFRESH_RATE);

		universe.setSize(WIDTH, HEIGHT);

		universe.setCellSize(CELL_WIDTH, CELL_HEIGHT);

	}

	private void addSeed(Universe universe) {

		if (readFromFolder) {

			for (File file : readLifFilesFromFolder()) {
				readSeedFromFile(universe, file);
			}
			return;
		}

		if (readFromFile) {

			readSeedFromFile(universe, lifFile);
			return;

		}

		List<SeedGenerator> seed = SeedFactory.create(SEEDS);
		universe.addSeedGenerator(seed);

	}

	private void readSeedFromFile(Universe universe, File file) {
		SeedGenerator seed = new LifFileSeedGenerator(file);
		universe.addSeedGenerator(seed);
	}

	private List<File> readLifFilesFromFolder() {
		List<File> files = new ArrayList<File>();
		for (final File fileEntry : LifFileFolder.listFiles()) {
			files.add(fileEntry);
		}
		return files;
	}

}