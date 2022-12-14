package datastructures.graphs;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Graph Traversal technique that ensures we traverse all the farthest level from an adjacent node
 *
 * Time complexity:
 * Adjacency List - O(V+E)
 * Adjacency Matrix - O(v^2)
 */
public class DepthFirstSearch {
    private ArrayList<Integer> dfsOfGraph(int vertices, ArrayList<ArrayList<Integer>> adjacencyList) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[vertices + 1];

        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == false) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                visited[i] = true;

                while (!stack.empty()) {
                    int node = stack.pop();
                    result.add(node);

                    for (Integer edge : adjacencyList.get(node)) {
                        if (visited[edge] == false) {
                            stack.push(edge);
                            visited[edge] = true;
                        }
                    }
                }
            }
        }

        return result;
    }
}
