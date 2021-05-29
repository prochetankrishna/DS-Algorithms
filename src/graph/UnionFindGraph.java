package graph;

public class UnionFindGraph {

    class Edge {
        int source, destination;

        public Edge() {};

        public Edge (int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    int numOfVertices, numOfEdges;
    Edge[] edges;

    UnionFindGraph (int numOfVertices, int numOfEdges) {
        this.numOfVertices = numOfVertices;
        this.numOfEdges = numOfEdges;
        edges = new Edge[this.numOfEdges];
        for (int i = 0; i < this.numOfEdges; i++) {
            edges[i] = new Edge();
        }
    }

    int find (int[] parent, int vertex) {

        if (parent[vertex] == -1) {
            return vertex;
        }
        return find (parent, parent[vertex]);
    }

    void union (int[] parent, int sourceParent, int destinationParent) {
        parent[sourceParent] = destinationParent;
    }

    public static void main(String[] args) {

        int numOfVertices = 3;
        int numOfEdges = 3;
        UnionFindGraph graph = new UnionFindGraph(numOfVertices, numOfEdges);

        graph.edges[0].source = 0;
        graph.edges[0].destination = 1;

        graph.edges[1].source = 1;
        graph.edges[1].destination = 2;

        graph.edges[2].source = 0;
        graph.edges[2].destination = 2;

        if (graph.isCycleExists(graph)) {
            System.out.println("Cycle Exists");
        } else {
            System.out.println("Cycle doesn't Exists");
        }
    }

    public boolean isCycleExists (UnionFindGraph graph) {

        int[] parent = new int[this.numOfVertices];

        for (int i = 0; i < this.numOfVertices; i++) {
            parent[i] = -1;
        }

        for (int i = 0; i < this.numOfEdges; i++) {

            int sourceParent = graph.find(parent, graph.edges[i].source);
            int destinationParent = graph.find(parent, graph.edges[i].destination);

            if (sourceParent == destinationParent) {
                return true;
            }

            graph.union(parent, sourceParent, destinationParent);
        }
        return false;
    }
}
