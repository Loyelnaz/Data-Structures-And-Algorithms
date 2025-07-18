package datastructures.graphs;

import java.util.ArrayList;
import java.util.Stack;

/**
 * You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi]
 * indicates that there is an edge between ai and bi in the graph. Return the number of connected components in the graph.
 */
public class ConnectedComponentsInUndirectedGraph {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{3,4}};
        System.out.println(countComponents(5, edges));
    }

    /**
     * Time Complexity - O(E+V), O(E) to generate adjacency list, and O(V) to traverse through each vertices
     * Space Complexity - O(E+V), O(E) space for adjacency list, and O(V) space for storing visited vertices in an array
     */
    public static int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjacencyList = adjacencyList(n, edges);
        boolean[] visited = new boolean[n];
        int componentCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, adjacencyList);
                componentCount++;
            }
        }
        return componentCount;
    }

    private static void dfs(int startNode, boolean[] visited, ArrayList<ArrayList<Integer>> adjacencyList) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);
        visited[startNode] = true;

        while (!stack.empty()) {
            int node = stack.pop();

            for (int edge : adjacencyList.get(node)) {
                if (!visited[edge]) {
                    stack.push(edge);
                    visited[edge] = true;
                }
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> adjacencyList(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        return adjacencyList;
    }
}
