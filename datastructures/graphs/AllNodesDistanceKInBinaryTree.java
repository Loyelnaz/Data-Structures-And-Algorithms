package datastructures.graphs;

import java.util.*;

/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class AllNodesDistanceKInBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // this is to keep track of all the neighbors of a given node
        // we already know the left and right neighbor, but need to track the top (parent) neighbor
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        // Perform a DFS on all the nodes, and store the parent corresponding to each node
        dfs(parents, root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();
        queue.add(target);
        seen.add(target);

        int distance = 0;
        while (!queue.isEmpty() && distance < k) {
            int currentLength = queue.size();
            for (int i = 0; i < currentLength; i++) {
                TreeNode node = queue.remove();
                // Traverse through all the eligible neighbors of a node - left, right and parent
                for (TreeNode neighbor : new TreeNode[]{node.left, node.right, parents.get(node)}) {
                    if (neighbor != null && !seen.contains(neighbor)) {
                        seen.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            distance++;
        }

        List<Integer> result = new ArrayList<>();
        for (TreeNode node : queue) {
            result.add(node.val);
        }

        return result;
    }

    private void dfs(Map<TreeNode, TreeNode> parents, TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }

        parents.put(node, parent);
        dfs(parents, node.left, node);
        dfs(parents, node.right, node);
    }
}
