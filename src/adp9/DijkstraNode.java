package adp9;

public class DijkstraNode extends Node implements Comparable<DijkstraNode>{
	
	public double minDistance = Double.POSITIVE_INFINITY;
	public Node previous;

	public DijkstraNode(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(DijkstraNode o) {
		return Double.compare(minDistance, o.minDistance);
	}

}
