package adp9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {


	public void computePaths(Node sourceNode) {

		sourceNode.minDistance = 0.;
		PriorityQueue<Node> NodeQueue = new PriorityQueue<Node>();
		NodeQueue.add(sourceNode);
		
		while (!NodeQueue.isEmpty()) {
			Node u = NodeQueue.poll();

			for (Edge edge : u.adjacencyList) {
				Node node = (Node) edge.node;
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

	public List<Node> getShortestPathTo(Node target) {

		List<Node> path = new ArrayList<Node>();
		for (Node node = target; node != null; node = (Node) node.previous)
			path.add(node);

		Collections.reverse(path);
		return path;
	}

	public void printMinDistanceFrom(Node location) {
		System.out.println("Distance from " + location + ": " + location.minDistance);

	}

	public void printShortesPathFrom(Node location) {
		List<Node> path = getShortestPathTo(location);
		System.out.println("Path: " + path);
	}

	public static void main(String[] args) {
		Graph test = new AdjacencyList();

		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		Node g = new Node("G");
		Node h = new Node("H");

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

		Dijkstra navigation = new Dijkstra();
		navigation.computePaths(a);
		navigation.printShortesPathFrom(h);
		navigation.printMinDistanceFrom(h);

	}
}
