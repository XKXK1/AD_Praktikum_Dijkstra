package adp9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

	public static void computePaths(DijkstraNode sourceNode) {

		sourceNode.minDistance = 0.;
		PriorityQueue<DijkstraNode> NodeQueue = new PriorityQueue<DijkstraNode>();
		NodeQueue.add(sourceNode);

		while (!NodeQueue.isEmpty()) {
			DijkstraNode u = NodeQueue.poll();

			for (Edge edge : u.adjacencyList) {
				DijkstraNode node = (DijkstraNode) edge.node;
				double weight = edge.weight;
				double distanceThroughU = u.minDistance + weight;

				if (distanceThroughU < node.minDistance) {
					NodeQueue.remove(node);

					node.minDistance = distanceThroughU;
					node.previous = u;
					NodeQueue.add(node);
				}
			}
		}
	}

	public static List<DijkstraNode> getShortestPathTo(DijkstraNode target) {

		List<DijkstraNode> path = new ArrayList<DijkstraNode>();
		for (DijkstraNode node = target; node != null; node = (DijkstraNode) node.previous)
			path.add(node);

		Collections.reverse(path);
		return path;
	}

	public static void main(String[] args) {
		Graph test = new AdjacencyList();

		DijkstraNode a = new DijkstraNode("A");
		DijkstraNode b = new DijkstraNode("B");
		DijkstraNode c = new DijkstraNode("C");
		DijkstraNode d = new DijkstraNode("D");
		DijkstraNode e = new DijkstraNode("E");
		DijkstraNode f = new DijkstraNode("F");
		DijkstraNode g = new DijkstraNode("G");
		DijkstraNode h = new DijkstraNode("H");

		test.insertNode(a);
		test.insertNode(b);
		test.insertNode(c);
		test.insertNode(d);
		test.insertNode(e);
		test.insertNode(f);
		test.insertNode(g);
		test.insertNode(h);

		test.insertEdge(a, b, 8);
		test.insertEdge(a, c, 2);
		test.insertEdge(a, d, 5);

		test.insertEdge(b, d, 2);
		test.insertEdge(b, f, 13);

		test.insertEdge(c, e, 5);
		test.insertEdge(c, d, 2);

		test.insertEdge(d, f, 6);
		test.insertEdge(d, e, 1);
		test.insertEdge(d, g, 3);

		test.insertEdge(e, g, 1);

		test.insertEdge(f, h, 3);
		
		test.insertEdge(g, f, 2);
		test.insertEdge(g, h, 6);
		

		computePaths(a);
		System.out.println("Distance to " + h + ": " + h.minDistance);
		List<DijkstraNode> path = getShortestPathTo(h);
		System.out.println("Path: " + path);

	}
}







