package conwaysGameOfLife;

public class Visited {

	private int amountVisitors = 0;

	void visit() {
		amountVisitors++;
	}

	int visitors() {
		return amountVisitors;
	}

}