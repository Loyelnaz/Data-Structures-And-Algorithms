package datastructures.graphs;

import java.util.*;

/**
 * Given a directed acyclic graph, with n vertices numbered from 0 to n-1,
 * and an array edges where edges[i] = [x, y] represents a directed edge from node x to node y.
 * Find the smallest set of vertices from which all nodes in the graph are reachable.
 *
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
 */
public class MinVerticesToReachAllNodes {

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(0);
        l1.add(1);
        edges.add(l1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(0);
        l2.add(2);
        edges.add(l2);
        List<Integer> l3 = new ArrayList<>();
        l3.add(2);
        l3.add(5);
        edges.add(l3);
        List<Integer> l4 = new ArrayList<>();
        l4.add(3);
        l4.add(4);
        edges.add(l4);
        List<Integer> l5 = new ArrayList<>();
        l5.add(4);
        l5.add(2);
        edges.add(l5);

        int n = 6;
        System.out.println(findSmallestSetOfVertices(n, edges));
    }

    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // The problem can be rephrased as smallest set of nodes that cannot be reached from other nodes
        // Keep track of in-degrees of all the nodes
        // Any node that has indegree as 0, we will consider those nodes as not reachable
        int[] indegrees = new int[n];

        for (List<Integer> edge : edges) {
            indegrees[edge.get(1)]++;
        }

        List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                vertices.add(i);
            }
        }

        return vertices;
    }
}
