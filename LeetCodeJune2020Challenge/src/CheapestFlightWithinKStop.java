import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightWithinKStop {

    public static void main(String[] args) {
        /*int n = 5;
        int[][] flights =
                {
                        {1, 2, 10},
                        {2, 0, 7},
                        {1, 3, 8},
                        {4, 0, 10},
                        {3, 4, 2},
                        {4, 2, 10},
                        {0, 3, 3},
                        {3, 1, 6},
                        {2, 4, 5}
                };
        int src = 0;
        int dst = 4;
        int k = 1;*/

        int n = 5;
        int[][] flights =
                {{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}};
        int src = 0;
        int dst = 2;
        int k = 2;
        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] adj = new int[n][n];
        for (int i = 0; i < flights.length; i++) {
            int r = flights[i][0];
            int c = flights[i][1];
            adj[r][c] = flights[i][2];
        }
        Queue<Node> queue = new LinkedList<>();

        boolean[] visit = new boolean[n];
        int min = Integer.MAX_VALUE;
        queue.add(new Node(src, 0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            visit[node.v] = true;

            if (node.v == dst) {
                min = Math.min(min, node.cost);
            }

            if (node.k <= K) {
                for (int c = 0; c < n; c++) {
                    if (!visit[c] && adj[node.v][c] != 0) {
                        queue.add(new Node(c, node.k + 1, node.cost + adj[node.v][c]));
                    }
                }
            }

        }

        return min > 0 ? min : -1;
    }

    static class Node {
        int v;
        int k;
        int cost;

        Node(int v, int k, int cost) {
            this.v = v;
            this.k = k;
            this.cost = cost;
        }
    }
}
