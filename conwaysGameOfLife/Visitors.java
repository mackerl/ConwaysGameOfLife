package conwaysGameOfLife;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Visitors {

	private Map<Cell, Visited> visitors = new HashMap<Cell, Visited>();

	public Map<Cell, Visited> getVisitors() {
		return visitors;
	}

	public void visit(Cell coordinate) {
		if (visitors.containsKey(coordinate)) {
			Visited visited = visitors.get(coordinate);
			visited.visit();
		}
	}

	public void visit(List<Cell> cells) {
		for (Cell cell : cells) {
			visit(cell);
		}
	}

}
