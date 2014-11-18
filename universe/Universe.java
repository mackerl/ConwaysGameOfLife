package universe;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import rules.CellRuleApplier;
import seed.SeedGenerator;

public class Universe {

	private boolean exit = false;

	class exitTask extends TimerTask {

		@Override
		public void run() {
			exit = true;
		}
	}

	private final Cells cells = new Cells();

	private List<SeedGenerator> seedGenerators = new ArrayList<SeedGenerator>();

	public void addSeedGenerator(SeedGenerator seedGenerator) {
		seedGenerators.add(seedGenerator);
	}

	public void start() {
		for (SeedGenerator seedGenerator : seedGenerators) {
			List<Cell> seed = seedGenerator.generate();
			cells.createCell(seed);
		}
		System.out.println("<<<<<<<<<<<<< Starting my universe <<<<<<<<<<<<<");

		Timer timer = new Timer();
		timer.schedule(new exitTask(), 2000);

		while (!isEmpty()) {
			tick();
			if (exit) {
				System.out
						.println("<<<<<<<<<<<<< Universe Time Expired <<<<<<<<<<<<<");
				System.exit(0);
			}
		}
		System.out.println("<<<<<<<<<<<<< Universe is Dead <<<<<<<<<<<<<");

	}

	private void tick() {
		applyRules();
		printUniverse();

		System.out.println();
		System.out.println();
		System.out.println("<<<<<<<<<<<<< NEXT ITERATION <<<<<<<<<<<<<");
		System.out.println();
		System.out.println();
	}

	private void applyRules() {
		Visitors visitors = cells.visitNeighbours();
		CellRuleApplier cellRuleApplier = new CellRuleApplier(cells);
		visitors.applyRules(cellRuleApplier);
	}

	private void printUniverse() {
		cells.print();
	}

	private boolean isEmpty() {
		return cells.isEmpty();
	}

}
