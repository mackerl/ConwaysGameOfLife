package universe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.Timer;

import rules.CellRuleApplier;
import seed.SeedGenerator;

public class Universe extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public Universe() {
		super();
		initGui();
	}

	private void initGui() {
		super.getContentPane().add(gameOfLifeGui);
		super.pack();
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLocationByPlatform(true);
		super.setVisible(true);
		super.setSize(1000, 1000);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				System.out.println("<<<<<<<<<<<<< Universe is Dead, after "
						+ iterations + " iterations");
			}
		});
	}

	private int iterations = 0;

	private final Cells cells = new Cells();
	private final GameOfLifeGui gameOfLifeGui = new GameOfLifeGui(cells);
	private final Timer drawTimer = new Timer(100, this);

	private List<SeedGenerator> seedGenerators = new ArrayList<SeedGenerator>();

	public void addSeedGenerator(SeedGenerator seedGenerator) {
		seedGenerators.add(seedGenerator);
	}

	public void addSeedGenerator(List<SeedGenerator> seedGenerators) {
		for (SeedGenerator seedGenerator : seedGenerators) {
			this.seedGenerators.add(seedGenerator);
		}
	}

	public void start() {
		System.out.println("<<<<<<<<<<<<< Starting my universe <<<<<<<<<<<<<");
		for (SeedGenerator seedGenerator : seedGenerators) {
			List<Cell> seed = seedGenerator.generate();
			cells.createCell(seed);
		}

		drawTimer.start();

	}

	private void tick() {
		Visitors visitors = cells.visitNeighbours();
		CellRuleApplier cellRuleApplier = new CellRuleApplier(cells);
		visitors.applyRules(cellRuleApplier);
		++iterations;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		tick();
		gameOfLifeGui.repaint();
	}

}
