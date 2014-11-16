package conwaysGameOfLife;

import java.util.HashMap;
import java.util.Map;

public class Visitors {

	private Map<Coordinate, Visited> visitors = new HashMap<Coordinate, Visited>();

	public void visit(Coordinate coordinate) {
		if (visitors.containsKey(coordinate)) {
			Visited visited = visitors.get(coordinate);
			visited.visit();
		}
	}

}
