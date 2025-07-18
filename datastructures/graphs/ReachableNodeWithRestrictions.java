package datastructures.graphs;

import java.util.*;

/**
 * https://leetcode.com/problems/reachable-nodes-with-restrictions/description/
 */
public class ReachableNodeWithRestrictions {

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}};
        int[] restricted = {4, 5};
        int n = 7;
        System.out.println(reachableNodes(n, edges, restricted));
    }

    /**
     * Time complexity: O(n) - In a typical DFS search, the time complexity is O(V+E)
     *                         where V,E are the number of vertices and edges.
     *                         In this problem, there are n nodes and n−1 edges.
     * Space complexity: O(n) - We use a hash map to store "n - 1" edges which requires O(n) space.
     *                          We use seen, either a hash set or an array to record the visited nodes, which also takes O(n) space.
     *                          We use a stack stack to store all the nodes to be visited, in the worst-case scenario,
     *                          there may be O(n) nodes in stack.
     */
    public static int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] visited = new boolean[n];
        for (int node : restricted) {
            visited[node] = true;
        }

        Map<Integer, List<Integer>> graph = buildGraph(n, edges);
        return dfs(n, graph, visited);
    }

    private static int dfs(int n,Map<Integer, List<Integer>> graph, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        int nodeCount = 0;
        stack.add(0);
        visited[0] = true;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            nodeCount++;

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return nodeCount;
    }

    private static Map<Integer, List<Integer>> buildGraph(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, value -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, value -> new ArrayList<>()).add(a);
        }

        return graph;
    }
}
