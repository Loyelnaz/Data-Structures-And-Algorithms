package datastructures.graphs;

import java.util.*;

/**
 * There are n cities. A province is a group of directly or indirectly connected cities
 * and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = isConnected[j][i] = 1
 * if the ith and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * Return the total number of provinces.
 */
public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }

    /**
     * Time Complexity - O(n + e)
     * Space Complexity - O(n + e)
     */
    public static int findCircleNum(int[][] isConnected) {
        // pre-process given matrix and convert into a hashmap
        Map<Integer, List<Integer>> graph = buildGraph(isConnected);
        int numberOfProvinces = 0;
        Set<Integer> visited = new HashSet<>();
        for (Integer node : graph.keySet()) {
            // consider only the newly visited nodes while calculating the provinces
            if (traverse(node, graph, visited)) {
                numberOfProvinces++;
            }
        }
        return numberOfProvinces;
    }

    private static boolean traverse(Integer node, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);

        for (Integer neighbor : graph.get(node)) {
            traverse(neighbor, graph, visited);
        }

        return true;
    }

    private static Map<Integer, List<Integer>> buildGraph(int[][] isConnected) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int row = 0; row < isConnected.length; row++) {
            if (!graph.containsKey(row)) {
                graph.put(row, new ArrayList<>());
            }
            for (int col = row + 1; col < isConnected[row].length; col++) {
                if (!graph.containsKey(col)) {
                    graph.put(col, new ArrayList<>());
                }

                if (isConnected[row][col] == 1) {
                    graph.get(row).add(col);
                    graph.get(col).add(row);
                }
            }
        }
        return graph;
    }
}
