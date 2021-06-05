package graph;

import java.util.Arrays;
import java.util.LinkedList;

public class KruskalAlgorithm {

    class Edge implements Comparable<Edge>{

        int source, destination, weight;

        public Edge () {};

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge anotherEdge) {
            return this.weight - anotherEdge.weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "source=" + source +
                    ", destination=" + destination +
                    ", weight=" + weight +
                    '}';
        }
    }

    class Subset {

        int parent, rank;

        public Subset() {};

        public Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "Subset{" +
                    "parent=" + parent +
                    ", rank=" + rank +
                    '}';
        }
    }

    int numOfVertices;
    int numOfEdges;
    Edge[] edges;

    public KruskalAlgorithm (int numOfVertices, int numOfEdges) {
        this.numOfVertices = numOfVertices;
        this.numOfEdges = numOfEdges;
        this.edges = new Edge[numOfEdges];
        for (int i = 0; i < numOfEdges; i++) {
            edges[i] = new Edge();
        }
    }


    public static void main(String[] args) {

        /*
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        KruskalAlgorithm kruskalAlgorithmGraph = new KruskalAlgorithm(4, 5);

        kruskalAlgorithmGraph.edges[0].source = 0;
        kruskalAlgorithmGraph.edges[0].destination = 1;
        kruskalAlgorithmGraph.edges[0].weight= 10;

        kruskalAlgorithmGraph.edges[1].source = 0;
        kruskalAlgorithmGraph.edges[1].destination = 2;
        kruskalAlgorithmGraph.edges[1].weight= 6;

        kruskalAlgorithmGraph.edges[2].source = 0;
        kruskalAlgorithmGraph.edges[2].destination = 3;
        kruskalAlgorithmGraph.edges[2].weight= 5;

        kruskalAlgorithmGraph.edges[3].source = 1;
        kruskalAlgorithmGraph.edges[3].destination = 3;
        kruskalAlgorithmGraph.edges[3].weight= 15;

        kruskalAlgorithmGraph.edges[4].source = 2;
        kruskalAlgorithmGraph.edges[4].destination = 3;
        kruskalAlgorithmGraph.edges[4].weight= 4;

        kruskalAlgorithmGraph.findKruskalMST();
    }

    private void findKruskalMST() {

        Edge[] resultantEdges = new Edge[this.numOfVertices];
        for (int i = 0; i < this.numOfVertices; i++) {
            resultantEdges[i] = new Edge();
        }
        int resultantEdgesCounter = 0;

        Arrays.sort(this.edges);

        Subset[] subsets = new Subset[this.numOfVertices];
        for (int i = 0; i < this.numOfVertices; i++) {
            subsets[i] = new Subset(i, 0);
        }

        int nextEdgeIndex = 0;

        while (resultantEdgesCounter < this.numOfVertices - 1) {

            Edge currentEdge = this.edges[nextEdgeIndex++];

            int srcParent = findParent (subsets, currentEdge.source);
            int destParent = findParent (subsets, currentEdge.destination);

            if (srcParent != destParent) {
                resultantEdges[resultantEdgesCounter++] = currentEdge;
                union (subsets, srcParent, destParent);
            }
        }

        System.out.println("Following are the edges in the constructed MST");
        int minimumCost = 0;
        for (int i = 0; i < resultantEdgesCounter; ++i)
        {
            System.out.println(resultantEdges[i].source + " -- "
                    + resultantEdges[i].destination
                    + " == " + resultantEdges[i].weight);
            minimumCost += resultantEdges[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree "
                + minimumCost);
    }

    public int findParent (Subset[] subsets, int vertex) {
        if (subsets[vertex].parent != vertex) {
            subsets[vertex].parent = findParent (subsets, subsets[vertex].parent);
        }
        return subsets[vertex].parent;
    }

    public void union (Subset[] subsets, int source, int destination) {

        int srcParent = findParent (subsets, source);
        int destParent = findParent (subsets, destination);

        if (subsets[srcParent].rank < subsets[destParent].rank) {
            subsets[srcParent].parent = destParent;
        } else if (subsets[srcParent].rank > subsets[destParent].rank) {
            subsets[destParent].parent = srcParent;
        } else {
            subsets[destParent].parent = srcParent;
            subsets[srcParent].rank++;
        }
    }
}
