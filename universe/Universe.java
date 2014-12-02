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
	private int refreshRate = 100;
	private final int DEFAULT_SIZE = 1000;

	private int iterations = 0;

	private final Cells cells = new Cells();
	private final GameOfLifeGui gameOfLifeGui = new GameOfLifeGui(cells);

	private List<SeedGenerator> seedGenerators = new ArrayList<SeedGenerator>();

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
		super.setSize(DEFAULT_SIZE, DEFAULT_SIZE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				System.out.println("<<<<<<<<<<<<< Universe is Dead, after "
						+ iterations + " iterations");
			}
		});
		add(new StartButton(this));
	}

	public void start() {
		System.out.println("<<<<<<<<<<<<< Starting my universe <<<<<<<<<<<<<");
		spraySeed();
		Timer drawTimer = new Timer(refreshRate, this);
		drawTimer.start();

	}

	private void spraySeed() {
		for (SeedGenerator seedGenerator : seedGenerators) {
			List<Cell> seed = seedGenerator.generate();
			cells.createCell(seed);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		tick();
	}

	private void tick() {
		CellRuleApplier cellRuleApplier = new CellRuleApplier(cells);
		cellRuleApplier.applyRules();
		gameOfLifeGui.repaint();
		++iterations;
	}

	public void setREFRESH_RATE(int rEFRESH_RATE) {
		refreshRate = rEFRESH_RATE;
	}

	public void addSeedGenerator(List<SeedGenerator> seedGenerators) {
		for (SeedGenerator seedGenerator : seedGenerators) {
			this.seedGenerators.add(seedGenerator);
		}
	}

	public void addSeedGenerator(SeedGenerator seedGenerator) {
		seedGenerators.add(seedGenerator);
	}

	public void setCellSize(int cellWitdth, int cellHeight) {
		gameOfLifeGui.setCellWitdth(cellWitdth);
		gameOfLifeGui.setCellHeight(cellHeight);
	}

}
