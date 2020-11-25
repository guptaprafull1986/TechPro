package graph;

import java.util.Arrays;

public class MColorProblem {
    public static void main(String[] args) {
        /* Create following graph and test whether it is
           3 colorable
          (3)---(2)
           |   / |
           |  /  |
           | /   |
          (0)---(1)
        */
        int graph[][] =
                {
                        {0, 1, 1, 1},
                        {1, 0, 1, 0},
                        {1, 1, 0, 1},
                        {1, 0, 1, 0},
                };
        int m = 3; // Number of colors

        graphColoring(graph, m, graph.length);
    }

    private static void graphColoring(int[][] graph, int m, int V) {
        int[] color = new int[V];
        Arrays.fill(graph, 0);

        if (!graphColoringUtil(graph, color, m, 0, V)) {
            System.out.println("coloring not possible");
        } else {
            System.out.println("Coloring is possible");
            for (int n :
                    color) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static boolean graphColoringUtil(int[][] adj, int[] color, int m, int v, int V) {
        if (v == V) return true;

        for (int c = 1; c <= m; c++) {
            if (isSafe(adj, color, v, V, c)) {
                color[v] = c;
                if (graphColoringUtil(adj, color, m, v + 1, V)) {
                    return true;
                }
                color[v] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] adj, int[] color, int v, int V, int c) {
        for (int i = 0; i < V; i++) {
            if (adj[v][i] == 1 && color[i] == c) {
                return false;
            }
        }
        return true;
    }
}
