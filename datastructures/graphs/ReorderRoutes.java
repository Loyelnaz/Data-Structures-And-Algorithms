package datastructures.graphs;

import java.util.*;

/**
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities.
 * Roads are represented by connections where connections[i] = [x, y] represents a road from city x to city y.
 * The edges are directed. You need to swap the direction of some edges so that every city can reach city 0.
 * Return the minimum number of swaps needed.
 *
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 */
public class ReorderRoutes {
    public static void main(String[] args) {
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        int n = 6;
        System.out.println(minReorder(n, connections));
    }

    static Set<String> roads = new HashSet<>();

    /**
     * Time Complexity - O(n), each node is visited only once
     * Space Complexity - O(n), "roads", "graphs" and "visited" all take up at most O(n) space
     */
    public static int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> graph = buildGraph(connections, n);
        Set<Integer> visited = new HashSet<>();

        visited.add(0);
        return dfs(graph, visited, 0);
    }

    private static int dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int node) {
        int swapCount = 0;
        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                if (roads.contains(buildString(node, neighbor))) {
                    swapCount++;
                }

                visited.add(neighbor);
                swapCount += dfs(graph, visited, neighbor);
            }
        }

        return swapCount;
    }

    public static Map<Integer, List<Integer>> buildGraph(int[][] connections, int n) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] connection : connections) {
            int nodeA = connection[0];
            int nodeB = connection[1];

            graph.get(nodeA).add(nodeB);
            graph.get(nodeB).add(nodeA);
            roads.add(buildString(nodeA, nodeB));
        }
        return graph;
    }

    private static String buildString(int row, int col) {
        return row + "," + col;
    }
}
