package graph;

public class PrimsAlgorithm {

    static int numOfVertices;

    public static void main(String[] args) {

        numOfVertices = 5;
        int graph[][] = new int[][] {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };

        performPrimsAlgorithm(graph);
    }

    private static void performPrimsAlgorithm(int[][] graph) {

        int[] parent = new int[numOfVertices];
        int[] key = new int[numOfVertices];
        boolean[] mstSet = new boolean[numOfVertices];

        for (int i= 0; i < numOfVertices; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        //Include 1st Vertex
        key[0] = 0; //'0' means vertex is picked
        parent[0] = -1; //'-1' means this is root

        for (int count = 0; count < numOfVertices - 1; count++) {

            //Find the minimum key vertex from the set of vertex which is not yet included in MST
            int u = findMinKey (key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < numOfVertices; v++) {
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST (parent, graph);
    }

    private static void printMST(int[] parent, int[][] graph) {

        System.out.println("Edge \tWeight");
        for (int i = 1; i < numOfVertices; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    private static int findMinKey(int[] key, boolean[] mstSet) {

        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int i = 0; i < numOfVertices; i++) {
            if (mstSet[i] == false && key[i] < min) {
                min = key[i];
                min_index = i;
            }
        }
        return min_index;
    }
}
