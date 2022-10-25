package datastructures.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Find the mother vertex (vertex from each all the other vertices can be reached) in a directed graph.
 */
public class MotherVertexInDirectedGraph {
    public static void main(String[] args) {
        int vertices = 4;
        List<Integer> adjacencyList[] = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }

        adjacencyList[0].add(3);
        adjacencyList[1].add(3);
        adjacencyList[1].add(0);
        adjacencyList[2].add(1);

        System.out.println(findMotherVertex(adjacencyList));
    }

    //TODO fix the code
    public static int findMotherVertex(List<Integer> adjacencyList[]) {
        int vertices = adjacencyList.length;
        boolean[] visited = new boolean[vertices];
        Arrays.fill(visited, false);

        int possibleMotherVertex = 0;
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(adjacencyList, i, visited);
                possibleMotherVertex = i;
            }
        }

        Arrays.fill(visited, false);
        dfs(adjacencyList, possibleMotherVertex, visited);

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return -1;
            }
        }

        return possibleMotherVertex;
    }

    private static void dfs(List<Integer> adjacencyList[], int vertex, boolean[] visited) {
        visited[vertex] = true;
        for (int edge : adjacencyList[vertex]) {
            if (!visited[edge]) {
                dfs(adjacencyList, edge, visited);
            }

        }
    }
}
