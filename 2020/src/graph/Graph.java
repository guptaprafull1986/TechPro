package graph;

import java.util.ArrayList;

public class Graph {
    int V;
    ArrayList<ArrayList<Integer>> adjList;

    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v) {
        adjList.get(u).add(v);
//        adjList.get(v).add(u);
    }

    void print() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + " : ");

            for (int n : adjList.get(i)) {
                System.out.print(" -> " + n);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.print();
    }
}
