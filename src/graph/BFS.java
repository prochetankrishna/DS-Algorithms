package graph;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    int numVertices;
    LinkedList<Integer>[] adjacencyList;

    public BFS (int numVertices) {

        this.numVertices = numVertices;
        adjacencyList = new LinkedList[this.numVertices];

        for (int i = 0; i < this.numVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge (int source, int destination) {

        adjacencyList[source].add(destination);
    }

    public static void main(String[] args) {

        BFS graph = new BFS(7);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 6);
        graph.addEdge(5, 6);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        System.out.println(Arrays.toString(graph.adjacencyList));
        graph.breadthFirstSearch(0);
    }

    public void breadthFirstSearch (int startPosition) {

        boolean[] isVisited = new boolean[this.numVertices];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startPosition);

        isVisited[startPosition] = true;

        while (!queue.isEmpty()) {

            int vertexFromQueue = queue.poll();
            System.out.print(vertexFromQueue + " ");

            LinkedList<Integer> adjacentVertexList = this.adjacencyList[vertexFromQueue];
            for (Integer adjacentVertex : adjacentVertexList) {
                if (!isVisited[adjacentVertex]) {
                    queue.offer(adjacentVertex);
                    isVisited[adjacentVertex] = true;
                }
            }
        }
        System.out.println();
    }
}
