package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphUsingArray {
    private int n;
    private int[][] adj;

    public GraphUsingArray(int n) {
        this.n = n;
        adj = new int[n][n];
    }

    void addEdge(int u, int v) {
        adj[u][v] = 1;
        adj[v][u] = 1;
        //adj.get(u).add(v);
        //adj.get(v).add(u);
    }


    void printGraph() {
        for (int i = 0; i < n; i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            for (int j = 0; j < n; j++) {
                System.out.print(" -> " + adj[i][j]);
            }
            System.out.println();
        }
    }

    // Driver Code
    public static void main(String[] args) {
        // Creating a graph with 5 vertices
        int V = 5;
        ArrayList<ArrayList<Integer>> adj
                = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());
        GraphUsingArray graph = new GraphUsingArray(5);
        // Adding edges one by one
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();
    }

    // prints BFS traversal from a given source s
    public void bfs(int source) {
        boolean[] visit = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            source = queue.poll();
            System.out.print(source + " ");
            visit[source] = true;
            for (int i = 0; i < n; i++) {
                if (adj[source][i] != 0 && !visit[i]) {
                    queue.add(i);
                }
            }
        }

        System.out.println();
    }

    public void dfs(int source) {
        boolean[] visit = new boolean[n];
        dfsUtils(source, visit);
        System.out.println();
    }

    private void dfsUtils(int source, boolean[] visit) {
        visit[source] = true;
        System.out.print(source + " ");

        for (int i = 0; i < n; i++) {
            if (adj[source][i] == 1 && !visit[i]) {
                dfsUtils(i, visit);
            }
        }
    }

    public boolean isCyclic() {
        boolean[] visit = new boolean[n];

        Arrays.fill(visit, false);
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                if (cyclicUtil(i, visit, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean cyclicUtil(int source, boolean[] visit, int parent) {
        visit[source] = true;
        for (int i = 0; i < n; i++) {
            if (adj[source][i] == 1) {
                if (!visit[i]) {
                    if (cyclicUtil(i, visit, source)) {
                        return true;
                    }
                } else if (i != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}
