package adp9;

public class ComplexityTest {

	public void testIsConnectedAndGetNeighbors() {
		int zahl = 10;
		for (int i = 0; i < 2; i++) {
			System.out.println("-----------------------------------");
			System.out.println("Graph size: " + zahl);

			RandomGraphFactory factory = new RandomGraphFactory(zahl, 13);
			factory.buildGraph();
			AdjacencyList testList = factory.getResultListe();

			System.out.println("\nAdjacency-List:");
			testList.counter = 0;

			testList.getNeighbors(testList.getNodeList().get(zahl - 5));
			System.out.println("Counter for getNeighbors: " + testList.counter);
			testList.counter = 0;
			testList.connected(testList.getNodeList().get(zahl - 5), testList.getNodeList().get(zahl - 8));
			System.out.println("Counter for is x Neighbor of y: " + testList.counter);
			testList.counter = 0;

			AdjacencyMatrix testMatrix = factory.getResultMatrix();

			System.out.println("\nAdjacency-Matrix:");

			testMatrix.counter = 0;
			testMatrix.getNeighbors(testMatrix.nodes[zahl - 5]);
			System.out.println("Counter for getNeighbors: " + testMatrix.counter);
			testMatrix.counter = 0;
			testMatrix.connected(testMatrix.nodes[zahl - 5], testMatrix.nodes[zahl - 8]);
			System.out.println("Counter for is x Neighbor of y: " + testMatrix.counter);
			testMatrix.counter = 0;

			zahl *= 10;
		}

	}

	public void testDijkstra() {
		int zahl = 10;
		for (int i = 0; i < 3; i++) {
			System.out.println("-----------------------------------");
			System.out.println("Graph size: " + zahl);

			RandomGraphFactory factory = new RandomGraphFactory(zahl, 13);
			factory.buildGraph();
			
			AdjacencyList testList = factory.getResultListe();
			

			Dijkstra navigationList = new Dijkstra(testList);
			System.out.println("\nAdjacency-List-Dijkstra:");

			navigationList.computePaths(testList.getNodeList().get(0));
			System.out.println("Counter for Computing Paths: " + navigationList.counter);
			navigationList.counter = 0;

			navigationList.getShortestPathTo(testList.getNodeList().get(zahl - 5));
			System.out.println("Counter for getting shortest Path: " + navigationList.counter);

			navigationList.counter = 0;
			
			

			AdjacencyMatrix testMatrix = factory.getResultMatrix();
			

			Dijkstra navigationMatrix = new Dijkstra(testMatrix);
			System.out.println("\nAdjacency-Matrix-Dijkstra:");

			navigationMatrix.computePaths(testMatrix.nodes[0]);
			System.out.println("Counter for Computing Paths: " + navigationMatrix.counter);

			navigationMatrix.counter = 0;
			
			navigationMatrix.getShortestPathTo(testMatrix.nodes[zahl - 5]);
			System.out.println("Counter for getting shortest Path: " + navigationMatrix.counter);

			navigationMatrix.counter = 0;

			zahl *= 10;

		}

	}

	public static void main(String[] args) {
		ComplexityTest test = new ComplexityTest();
		// test.testIsConnectedAndGetNeighbors();
		test.testDijkstra();

	}

}
