package graph;

public class Bfs {
    public static void main(String[] args) {
        GraphUsingArray g = new GraphUsingArray(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");
        /** bfs execution */
        g.bfs(2);
        /** dfs execution */
        g.dfs(2);

        /** is cycle in graph */
        g = new GraphUsingArray(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        if (g.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");

        g = new GraphUsingArray(3);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        if (g.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
    }
}
