package adp9;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList implements Graph {

	public List<Node> nodeList;

	public AdjacencyList() {
		nodeList = new ArrayList<>();
	}

	@Override
	public void insertNode(Node newNode) {
		nodeList.add(newNode);
	}

	@Override
	public void removeNode(Node node) {
		Node runKnoten;
		Edge runKante;
		for (int i = 0; i < nodeList.size(); i++) {
			runKnoten = nodeList.get(i);
			for (int j = 0; j < runKnoten.adjacencyList.size(); j++) {
				runKante = runKnoten.adjacencyList.get(j);
				if (runKante.node == node) {
					runKnoten.adjacencyList.remove(j);
				}
			}
		}
		nodeList.remove(node);
	}


	public List<Node> getNodeList() {
		return nodeList;
	}

	@Override
	public List<Edge> getNeighbors(Node node) {
		return node.adjacencyList;
	}

	@Override
	public int getWeight(Node nodeOne, Node nodeTwo) {
		if (connected(nodeOne, nodeTwo)) {
			for(int i = 0; i < nodeOne.adjacencyList.size(); i++){
				if(nodeOne.adjacencyList.get(i).node==nodeTwo){
					return nodeOne.adjacencyList.get(i).weight;
				}
			}
		}
		return -1;
	}

	@Override
	public boolean connected(Node nodeOne, Node nodeTwo) {
		for (Edge i : nodeOne.adjacencyList) {
			if (i.node == nodeTwo)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String returnString = "";
		for (int i = 0; i < nodeList.size(); i++) {
			returnString += nodeList.get(i) + "\n";
		}
		return returnString;
	}

	@Override
	public void insertEdge(Node nodeOne, Node nodeTwo, int weight) {
		nodeOne.adjacencyList.add(0, new Edge(nodeTwo, weight));
		nodeTwo.adjacencyList.add(0, new Edge(nodeOne, weight));
	}

	@Override
	public void removeEdge(Node nodeOne, Node nodeTwo) {
			for(int i = 0; i < nodeOne.adjacencyList.size(); i++){
				if(nodeOne.adjacencyList.get(i).node==nodeTwo){
					nodeOne.adjacencyList.remove(i);
					continue;
				}
			}
			
			for(int i = 0; i < nodeTwo.adjacencyList.size(); i++){
				if(nodeTwo.adjacencyList.get(i).node==nodeOne){
					nodeTwo.adjacencyList.remove(i);
					continue;
				}
				nodeList.toArray(new Node[nodeList.size()]);
			}
	}
	



	public static void main(String[] args) {
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Graph test = new AdjacencyList();
		test.insertEdge(a, b, 5);
		test.insertEdge(a, c, 7);
		test.insertEdge(a, d, 2);
		test.insertEdge(e, d, 2);
		test.insertEdge(e, b, 1);
		test.insertNode(a);
		test.insertNode(b);
		test.insertNode(c);
		test.insertNode(d);
		test.insertNode(e);

		System.out.println(test);
		test.removeEdge(a, c);
		System.out.println(test);
		System.out.println(test.getWeight(a, b));
		
//		RandomGraphFactory factory = new RandomGraphFactory(1000, 13);
//		AdjacencyList test=  factory.buildGraph();
//
//		Dijkstra navigation = new Dijkstra();
//		
//		navigation.computePaths(test.getNodeList().get(0));
//		navigation.printMinDistanceFrom(test.getNodeList().get(5));

	}



}
