package datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-if-path-exists-in-graph/description/
 */
public class PathExists {

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{1,3},{2,3}};
        System.out.println(validPath(4, edges, 0, 3));
    }

    /**
     * Time complexity: O(n + e)
     * Space complexity: O(n + e)
     */
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = buildGraph(edges);
        boolean[] seen = new boolean[n];
        return dfs(graph, seen, source, destination);
    }

    private static boolean dfs(Map<Integer, List<Integer>> graph, boolean[] seen, int currNode, int destination) {
        if (currNode == destination) {
            return true;
        }
        seen[currNode] = true;
        for (int nextNode : graph.get(currNode)) {
            if (!seen[nextNode]) {  // Only call dfs if not seen
                if (dfs(graph, seen, nextNode, destination)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<>()).add(a);
        }
        return graph;
    }
}
