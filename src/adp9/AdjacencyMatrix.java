package adp9;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrix implements Graph  {
	//Variables
	private int notConnected = -1;
	private int same = 0;
	
	//Nodes
	public Node[] nodes;
	// Matrix
	public int[][] matrix;
	
	//Default Constructor
	public AdjacencyMatrix(){
		this.nodes = new Node[5];
		this.matrix = new int[5][5];
	}//constructor

	
	//Constructor with parameter
	public AdjacencyMatrix(int numNodes){
		this.nodes = new Node[numNodes];
		this.matrix = new int[numNodes][numNodes];
	}//constructor
	
	
	// Init of both Arrays with null or notConnected(inifity)
	public void initArrays(){
		for(int i = 0; i < nodes.length; i++){
			for(int j = 0; j < matrix[i].length ; j++){
				this.matrix[i][j] = notConnected;
			}
			this.nodes[i] = null;
		}
	}//method
	
	
	private int nodePos(Node node){
		int position = notConnected;
		// pos NodeOne
		for(int posNode = 0; posNode < nodes.length ;posNode++){
			if(nodes[posNode] == node){
				position = posNode;
				break;
			}//if
		}//for
		return position;
	}//method
	
	@Override
	public void insertNode(Node newNode){
		//add Node at the next possible position
		for(int i = 0; i < nodes.length ;i++){
			if(nodes[i] == null){
				this.nodes[i] = newNode;
				break;
			}//if
		}//for
	}//method
	
	@Override
	public void removeNode(Node node){
		int i;
		for(i = 0; i < nodes.length ;i++){
			if(nodes[i] == node){
				this.nodes[i] = null;
				break;
			}//if
		}//for
		
		for(int j = 0; j < matrix[i].length ;j++){
			this.matrix[i][j] = notConnected;
		}//for
		
	}//method
	
	@Override
	public List<Edge> getNeighbors(Node node){
		List<Edge> edges = new ArrayList<>();
		
		int posNode = nodePos(node);
		for(int j = 0; j < matrix[posNode].length; j++){
			if(matrix[posNode][j] != same && matrix[posNode][j] != notConnected){
				edges.add(new Edge(nodes[j], matrix[posNode][j]));
			}//if
		}//for
		return edges;
		
	}//method
	
	@Override
	public int getWeight(Node nodeOne, Node nodeTwo){
		
		int posNodeOne = nodePos(nodeOne);
		int posNodeTwo = nodePos(nodeTwo);
		
		return matrix[posNodeOne][posNodeTwo];
		
	}//method
	
	@Override
	public boolean connected(Node nodeOne, Node nodeTwo){
		
		int posNodeOne = nodePos(nodeOne);
		int posNodeTwo = nodePos(nodeTwo);
		
		//check
		if(matrix[posNodeOne][posNodeTwo] != same && matrix[posNodeOne][posNodeTwo] != notConnected){
			return true;
		}else{
			return false;
		}//if-else
		
	}//method
	
	@Override
	public void insertEdge(Node nodeOne, Node nodeTwo, int weight){
		
		int posNodeOne = nodePos(nodeOne);
		int posNodeTwo = nodePos(nodeTwo);
		
		//insert edge
		this.matrix[posNodeOne][posNodeTwo] = weight;
		
	}//method
	
	@Override
	public void removeEdge(Node nodeOne, Node nodeTwo){
		
		int posNodeOne = nodePos(nodeOne);
		int posNodeTwo = nodePos(nodeTwo);
		
		//remove edge
		this.matrix[posNodeOne][posNodeTwo] = notConnected;
		
	}//method
	
	public static void main(String[] args) {
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		
		Graph test = new AdjacencyMatrix();
		
		
		test.insertNode(a);
		test.insertNode(b);
		test.insertNode(c);
		test.insertNode(d);
		test.insertNode(e);
		
		test.insertEdge(a, b, 5);
		test.insertEdge(a, c, 7);
		test.insertEdge(a, d, 2);
		test.insertEdge(e, d, 2);
		test.insertEdge(e, b, 1);

		System.out.println(test);
		test.removeEdge(a, c);
		System.out.println(test);
		System.out.println(test.getWeight(a, b));
	}
	
}
