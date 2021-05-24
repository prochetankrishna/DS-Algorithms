package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {

    int numVertices;
    LinkedList<Integer>[] adjacencyList;

    public DFS(int numVertices) {

        this.numVertices = numVertices;
        adjacencyList = new LinkedList[this.numVertices];

        for (int i = 0; i < this.numVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {

        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source);
    }

    public static void main(String[] args) {

        DFS graph = new DFS(7);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 6);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        System.out.println(Arrays.toString(graph.adjacencyList));
        graph.depthFirstSearch();
        System.out.println();
        graph.depthFirstSearchRecursive();
    }

    public void depthFirstSearch () {

        boolean[] isVisited = new boolean[this.numVertices];

        Stack <Integer> stack = new Stack<>();
        stack.push(0);

        isVisited[0] = true;

        while (!stack.isEmpty()) {

            Integer currentVertex = stack.pop();
            System.out.print(currentVertex + " ");
            LinkedList<Integer> adjacentVertex = this.adjacencyList[currentVertex];
            for (Integer eachVertex : adjacentVertex) {
                if (!isVisited[eachVertex]) {
                   stack.push(eachVertex);
                   isVisited[eachVertex] = true;
                }
            }
        }
    }

    public void depthFirstSearchRecursive () {

        boolean[] isVisited = new boolean[this.numVertices];
        depthFirstSearchUtil(0, isVisited);
    }

    public void depthFirstSearchUtil (int currentVertex, boolean[] isVisited) {

        System.out.print(currentVertex + " ");
        isVisited [currentVertex] = true;

        LinkedList<Integer> adjacentVertex = this.adjacencyList[currentVertex];
        for (Integer nextVertex : adjacentVertex) {
            if (!isVisited[nextVertex]) {
                depthFirstSearchUtil(nextVertex, isVisited);
            }
        }
    }
}
