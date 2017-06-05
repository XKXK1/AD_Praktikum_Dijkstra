package adp9;

import java.util.List;

public interface Graph {
	void insertNode(Node newNode);
	
	void removeNode(Node node);
	
	List<Edge> getNeighbors(Node node);
	
	int getWeight(Node nodeOne, Node nodeTwo);
	
	boolean connected(Node nodeOne, Node nodeTwo);
	
	void insertEdge(Node nodeOne, Node nodeTwo, int weight);
	
	void removeEdge(Node nodeOne, Node nodeTwo);

	

}
