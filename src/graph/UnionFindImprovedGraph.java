package graph;

public class UnionFindImprovedGraph {

    class Edge {
        int source, destination;

        public Edge() {};

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    class Subset {

        int parent, rank;

        public Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    int numOfVertices, numOfEdges;
    Edge[] edges;

    public UnionFindImprovedGraph(int numOfVertices, int numOfEdges) {
        this.numOfVertices = numOfVertices;
        this.numOfEdges = numOfEdges;
        this.edges = new Edge[numOfEdges];
        for (int i = 0; i < numOfEdges; i++) {
            this.edges[i] = new Edge();
        }
    }

    public int find (Subset[] subsets, int vertex) {
        if (subsets[vertex].parent != vertex) {
            subsets[vertex].parent = find (subsets, subsets[vertex].parent);
        }
        return subsets[vertex].parent;
    }

    public void union (Subset[] subsets, int source, int destination) {

        int sourceParent = find (subsets, source);
        int destinationParent = find (subsets, destination);

        if (subsets[sourceParent].rank < subsets[destinationParent].rank) {
            subsets[sourceParent].parent = destinationParent;
        } else if (subsets[sourceParent].rank > subsets[destinationParent].rank) {
            subsets[destinationParent].parent = sourceParent;
        } else {
            subsets[sourceParent].parent = destinationParent;
            subsets[destinationParent].rank++;
        }
    }

    public boolean isCycleExists (UnionFindImprovedGraph graph) {

        Subset[] subsets = new Subset[this.numOfVertices];
        for (int i = 0; i < this.numOfVertices; i++) {
            subsets[i] = new Subset(i, 0);
        }

        for (int i = 0; i < this.numOfEdges; i++) {
            int sourceParent = find (subsets, graph.edges[i].source);
            int destinationParent = find (subsets, graph.edges[i].destination);

            if (sourceParent == destinationParent) {
                return true;
            }
            union(subsets, sourceParent, destinationParent);
        }
        return false;
    }

    public static void main(String[] args) {

        int numOfVertices = 3;
        int numOfEdges = 3;
        UnionFindImprovedGraph graph = new UnionFindImprovedGraph(numOfVertices, numOfEdges);

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
}
