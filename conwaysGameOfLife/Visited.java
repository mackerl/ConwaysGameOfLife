package conwaysGameOfLife;

public class Visited {

	private int amountVisitors = 0;

	public void visit() {
		amountVisitors++;
	}

	public void visit(int amount) {
		amountVisitors += amount;
	}

	public int visitors() {
		return amountVisitors;
	}

}