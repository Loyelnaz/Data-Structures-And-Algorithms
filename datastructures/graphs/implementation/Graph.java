package datastructures.graphs.implementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    // total number of vertices of a graph
    private int vertices;
    // array of linked lists
    private List<Integer> adjacencyList[];

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("|" + i + "| => ");
            if (adjacencyList[i] != null) {
                List<Integer> list = adjacencyList[i];
                list.forEach((temp) -> System.out.print("[" + temp + "] -> "));
                System.out.println("null");
            } else {
                System.out.println("|" + i + "| => "+ "null");
            }
        }
    }

    void addEdge(int source, int destination) {
        if (source < vertices && destination < vertices) {
            this.adjacencyList[source].add(destination);
            // for undirected graph, we would need to add other direction too
            // this.adacencyList[destination].add(source);
        }
    }
}
