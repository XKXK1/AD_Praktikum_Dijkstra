package adp9;

import java.util.Random;

public class RandomGraphFactory implements AbstractGraphFactory {
	
	AdjacencyList resultListe;
	AdjacencyMatrix resultMatrix;
	
	
	public final int LISTE = 1;
	public final int MATRIX = 2;

	/**
	 * the maximum weight of random connections
	 */
	private static final int MAX_WEIGHT = 20;
	private static final int MIN_WEIGHT = 1;
	

	/**
	 * the size of the Graph to be generated
	 */
	private int size;

	/**
	 * the seed to use when generating the Graph
	 */
	private long seed;

	public RandomGraphFactory(int size, long seed) {
		this.size = size;
		this.seed = seed;
	}
	

	@Override
	public void buildGraph() {
		resultListe = new AdjacencyList();
		resultMatrix = new AdjacencyMatrix(size);
		
		
		Random rand = new Random(seed);
		String nodeName = "K:{";

		for (int i = 0; i < size; i++) {
			resultListe.insertNode(new Node(nodeName+i+"}"));
			resultMatrix.insertNode(new Node(nodeName+i+"}"));
		}

		for (int j = 0; j < size; j++) {
			int randomSizeNeighbors = (int) ((Math.random()) * size);

			for (int i = 0; i < randomSizeNeighbors; i++) {
				int randomWeight = rand.nextInt(MAX_WEIGHT)+MIN_WEIGHT ;
				if(i != j){
					
				if(!resultListe.connected(resultListe.getNodeList().get(i), resultListe.getNodeList().get(j))){
					resultListe.insertEdge(resultListe.nodeList.get(j), resultListe.nodeList.get(i), randomWeight);
				}
				//System.out.println("Knoten 1 : " + resultMatrix.nodes[i] + "Knoten 2 : " + resultMatrix.nodes[j] + "connected : " + resultMatrix.connected(resultMatrix.nodes[i], resultMatrix.nodes[j]));
				if(!resultMatrix.connected(resultMatrix.nodes[i], resultMatrix.nodes[j])){
					resultMatrix.insertEdge(resultMatrix.nodes[j], resultMatrix.nodes[i], randomWeight);
				}//if
				}
			}
		}
	}



	public AdjacencyList getResultListe() {
		return resultListe;
	}



	public void setResultListe(AdjacencyList resultListe) {
		this.resultListe = resultListe;
	}



	public AdjacencyMatrix getResultMatrix() {
		return resultMatrix;
	}



	public void setResultMatrix(AdjacencyMatrix resultMatrix) {
		this.resultMatrix = resultMatrix;
	}


}
