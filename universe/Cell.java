package universe;

public class Cell {

	public int x = 0;
	public int y = 0;

	public Cell(int x, int y) {

		this.x = x;
		this.y = y;

	};

	public Cell() {
	}

	@Override
	public boolean equals(Object other) {
		Cell theOther = (Cell) other;
		if (x == theOther.x && y == theOther.y) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return x + y;
	}

}
