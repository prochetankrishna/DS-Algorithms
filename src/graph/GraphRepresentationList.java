package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GraphRepresentationList {

    static final int NUMBER_OF_VERTICES = 5;

    public static void main(String[] args) {

        List<Integer>[] arrayOfAdjacencyList = new List[NUMBER_OF_VERTICES];

        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            arrayOfAdjacencyList[i] = new LinkedList<>();
        }

        addEdges(arrayOfAdjacencyList, 0, 1);
        addEdges(arrayOfAdjacencyList, 0, 4);
        addEdges(arrayOfAdjacencyList, 1, 1);
        addEdges(arrayOfAdjacencyList, 1, 2);
        addEdges(arrayOfAdjacencyList, 1, 3);
        addEdges(arrayOfAdjacencyList, 1, 4);
        addEdges(arrayOfAdjacencyList, 3, 4);

        System.out.println(Arrays.toString(arrayOfAdjacencyList));
    }

    public static void addEdges (List<Integer>[] arrayOfAdjacencyList, int u, int v) {

        arrayOfAdjacencyList[u].add(v);
        //arrayOfAdjacencyList[v].add(u); //Un-Directed Graph
    }

}
