package adp9;

public class Edge {

	public Node node;
	public int weight;

	@Override
	public String toString() {
		return "( "+node.name+ " , " +weight+ ")";
	}

	

	public Edge(Node node, int weight) {
		this.node = node;
		this.weight = weight;
	}

}
