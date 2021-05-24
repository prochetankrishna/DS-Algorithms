package graph;

public class GraphRepresentationMatrix {

    static final int NUMBER_OF_VERTICES = 5;

    public static void main(String[] args) {

        int[][] adjacencyMatrix = new int[NUMBER_OF_VERTICES][NUMBER_OF_VERTICES];

        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            for (int j = 0; j < NUMBER_OF_VERTICES; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }

        addEdge(adjacencyMatrix, 0, 1);
        addEdge(adjacencyMatrix, 1, 1);
        addEdge(adjacencyMatrix, 1, 2);
        addEdge(adjacencyMatrix, 1, 3);
        addEdge(adjacencyMatrix, 1, 4);
        addEdge(adjacencyMatrix, 3, 4);
        addEdge(adjacencyMatrix, 0, 4);

        printAdjacencyMatrix(adjacencyMatrix);
    }

    public static void addEdge (int[][] adjacencyMatrix, int u, int v) {

        adjacencyMatrix[u][v] = 1;
        //adjacencyMatrix[v][u] = 1;  //Uncomment for Un-Directed Graph
    }

    public static void printAdjacencyMatrix (int[][] adjacencyMatrix) {

        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            for (int j = 0; j < NUMBER_OF_VERTICES; j++) {
                System.out.print (adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
