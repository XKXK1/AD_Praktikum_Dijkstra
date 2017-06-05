package adp9;

import java.util.Random;

public class RandomGraphFactory implements AbstractGraphFactory {

	/**
	 * the maximum weight of random connections
	 */
	private static final int MAX_WEIGHT = 20;

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
	public AdjacencyList buildGraph() {
		AdjacencyList result = new AdjacencyList();
		Random rand = new Random(seed);
		String nodeName = "K:{";

		for (int i = 0; i < size; i++) {
			result.insertNode(new Node(nodeName+i+"}"));
		}

		for (int j = 0; j < size; j++) {
			int random = (int) ((Math.random()) * size);

			for (int i = 0; i < random; i++) {
				if(i != j){
				if(!result.connected(result.getNodeList().get(i), result.getNodeList().get(j))){
				result.insertEdge(result.nodeList.get(j), result.nodeList.get(i), rand.nextInt(MAX_WEIGHT));
				}
				}
			}
		}
		return result;
	}

}
