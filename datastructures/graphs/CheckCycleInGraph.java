package datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheckCycleInGraph {

    static class Pair {
        int node;
        int parent;
        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    private static boolean checkCycleInGraph(int vertices, ArrayList<ArrayList<Integer>> adjacencyList) {
        boolean visited[] = new boolean[vertices + 1];

        // Loop to cover all the components of a graph
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == false) {
                if (isCycle(vertices, adjacencyList)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCycle(int vertices, ArrayList<ArrayList<Integer>> adjacencyList) {
        // visited[] to keep track of all the nodes visited
        boolean visited[] = new boolean[vertices + 1];

        // Loop to cover all the components of a graph
        for (int i = 1; i < visited.length; i++) {
            // Perform BFS traversal only if the node is not visited previously
            if (visited[i] == false) {
                // Since we traverse adjacent nodes in a BFS, a queue works perfectly
                Queue<Pair> queue = new LinkedList<>();
                queue.add(new Pair(i, -1));
                visited[i] = true;

                while (!queue.isEmpty()) {
                    Pair pair = queue.poll();
                    int node = pair.node;
                    int parentNode = pair.parent;

                    // For a given node, get all the edges from the adjacency list
                    for (Integer edge : adjacencyList.get(node)) {
                        if (visited[edge] == false) {
                            queue.add(new Pair(edge, node));
                            visited[edge] = true;
                        } else if (edge != parentNode) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
