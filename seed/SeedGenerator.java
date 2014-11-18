package seed;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import universe.Cell;

public abstract class SeedGenerator {

	List<Cell> cells = new ArrayList<Cell>();
	final int xoff;
	final int yoff;
	final Random rand = new Random();

	protected abstract void generateList();

	SeedGenerator() {
		xoff = rand.nextInt(Integer.MAX_VALUE) % 100 + 1;
		yoff = rand.nextInt(Integer.MAX_VALUE) % 100 + 1;
		System.out.println("offs: " + xoff + " , " + yoff);
	}

	public final List<Cell> generate() {
		generateList();
		return cells;
	}

	protected SeedGenerator add(int x, int y) {
		cells.add(new Cell(x + xoff, y + yoff));
		return this;
	}
}
