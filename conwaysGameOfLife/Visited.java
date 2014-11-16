package conwaysGameOfLife;

public class Visited {

	private int amountVisitors = 0;

	void visit() {
		amountVisitors++;
	}

	void visit(int amount) {
		amountVisitors += amount;
	}

	int visitors() {
		return amountVisitors;
	}

}