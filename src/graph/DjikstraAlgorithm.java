package graph;

import java.util.Arrays;

public class DjikstraAlgorithm {

    private int numVertices;
    private int[][] adjacencyMatrix;

    public DjikstraAlgorithm (int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[this.numVertices][this.numVertices];
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    public void addEdge (int source, int destination, int weight) {

        adjacencyMatrix[source][destination]  = weight;
        adjacencyMatrix[destination][source] = weight;
    }

    public static void main(String[] args) {

        DjikstraAlgorithm graph = new DjikstraAlgorithm(9);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(5, 3, 14);
        graph.addEdge(2, 5, 4);
        graph.addEdge(2, 8, 2);
        graph.addEdge(8, 6, 6);
        graph.addEdge(7, 8, 7);

        graph.printAdjacencyMatrix();

        graph.performDjikstraAlgorithm(0);
    }

    public void performDjikstraAlgorithm (int source) {

        int[] distance = new int[this.numVertices];
        boolean[] sptSet = new boolean[this.numVertices];

        for (int i = 0; i < this.numVertices; i++) {
            distance[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        distance[source] = 0;

        for (int count = 0; count < this.numVertices - 1; count++) {

//            System.out.println("*********************************************************************");
//            System.out.println("Count : " + count);
//            System.out.println(Arrays.toString(distance));
//            System.out.println(Arrays.toString(sptSet));
            int minimumDistanceVertex = findMinimumDistanceVertex (distance, sptSet);
//            System.out.println("Minimum Distance Vertex : " + minimumDistanceVertex);
//            System.out.println("*********************************************************************");
            sptSet[minimumDistanceVertex] = true;

            for (int eachVertex = 0; eachVertex < this.numVertices; eachVertex++) {

                if (!sptSet[eachVertex] && this.adjacencyMatrix[minimumDistanceVertex][eachVertex] != 0 &&
                        distance[minimumDistanceVertex] != Integer.MAX_VALUE &&
                                distance[minimumDistanceVertex] + this.adjacencyMatrix[minimumDistanceVertex][eachVertex] < distance[eachVertex]) {
//                    System.out.println("######################################################################");
//                    System.out.println("Minimum Distance Vertex : [" + minimumDistanceVertex + "], Each Vertex : [" + eachVertex + "]");
//                    System.out.println("######################################################################");
                    distance[eachVertex] = distance[minimumDistanceVertex] + this.adjacencyMatrix[minimumDistanceVertex][eachVertex];
                }
            }
        }
        //printSolution(distance);
    }

    private int findMinimumDistanceVertex(int[] distance, boolean[] sptSet) {

        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;

        for (int i = 0; i < this.numVertices; i++) {

            if (sptSet[i] == false && minDistance > distance[i]) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

    public void printAdjacencyMatrix () {
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printSolution(int[] distance)
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < this.numVertices; i++)
            System.out.println(i + " \t\t " + distance[i]);
    }
}
