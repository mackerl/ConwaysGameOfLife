package conwaysGameOfLife;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Universe {

	private boolean exit = false;

	class exitTask extends TimerTask {

		@Override
		public void run() {
			exit = true;
		}
	}

	private final Cells cells = new Cells();
	private Visitors visitors = null;
	private final CellRuleApplier cellRuleApplier = new CellRuleApplier();

	private SeedGenerator seedGenerator;

	public void setSeedGenerator(SeedGenerator seedGenerator) {
		this.seedGenerator = seedGenerator;
	}

	public void start() {
		if (seedGenerator != null) {
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
		visitNeighbours();
		applyRules();
		printUniverse();

		System.out.println();
		System.out.println();
		System.out.println("<<<<<<<<<<<<< NEXT ITERATION <<<<<<<<<<<<<");
		System.out.println();
		System.out.println();
	}

	private void visitNeighbours() {
		visitors = cells.visitNeighbours();
	}

	private void applyRules() {
		cellRuleApplier.setCells(cells);
		visitors.applyRules(cellRuleApplier);
	}

	private void printUniverse() {
		cells.print();
	}

	private boolean isEmpty() {
		return cells.isEmpty();
	}

}
