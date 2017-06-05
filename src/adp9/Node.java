package adp9;

import java.util.ArrayList;
import java.util.List;

public class Node {

	public List<Edge> adjacencyList = new ArrayList<>();
	public String name;


	public Node(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String returString = "" + name + "->";
		for (int i = 0; i < adjacencyList.size(); i++) {
			returString += "| " + adjacencyList.get(i) + " |";
		}
		return returString;
	}


}




//public class Node implements Comparable<Node> {
//
//	public List<Edge> adjacencyList = new ArrayList<>();
//	public String name;
//	public double minDistance = Double.POSITIVE_INFINITY;
//	public Node previous;
//
//	public Node(String name) {
//		this.name = name;
//
//	}
//
//	@Override
//	public String toString() {
//		String returString = "" + name + "->";
//		for (int i = 0; i < adjacencyList.size(); i++) {
//			returString += "| " + adjacencyList.get(i) + " |";
//		}
//		return returString;
//	}
//
//	 public int compareTo(Node other)
//	    {
//	        return Double.compare(minDistance, other.minDistance);
//	    }
//}
