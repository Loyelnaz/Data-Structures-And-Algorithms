package datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    private ArrayList<Integer> bfsOfGraph(int vertices, ArrayList<ArrayList<Integer>> adjacencyList) {
        ArrayList<Integer> result = new ArrayList<>();
        // visited[] to keep track of all the nodes visited
        boolean visited[] = new boolean[vertices + 1];

        // Loop to cover all the components of a graph
        for (int i = 1; i < visited.length; i++) {
            // Perform BFS traversal only if the node is not visited previously
            if (visited[i] == false) {
                // Since we traverse adjacent nodes in a BFS, a queue works perfectly
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    result.add(node);

                    // For a given node, get all the edges from the adjacency list
                    for (Integer edge : adjacencyList.get(node)) {
                        if (visited[edge] == false) {
                            queue.add(edge);
                            visited[edge] = true;
                        }
                    }
                }
            }
        }
        return result;
    }
}
