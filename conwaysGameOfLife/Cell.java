package conwaysGameOfLife;

public class Cell implements Comparable<Cell> {

	public int x;
	public int y;

	public Cell(int x, int y) {

		this.x = x;
		this.y = y;

	};

	public boolean equals(Cell toCompare) {
		if (x == toCompare.x && y == toCompare.y) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Cell toCompare) {
		if (equals(toCompare)) {
			return 0;
		} else if (x < toCompare.x && y < toCompare.y) {
			return -1;
		} else {
			return 1;
		}
	}

}
