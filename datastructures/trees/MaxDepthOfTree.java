package datastructures.trees;

import java.util.Stack;

/**
 * Leetcode - https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
public class MaxDepthOfTree {
    class Pair {
        TreeNode node;
        int depth;

        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    /**
     * Iterative approach to find the maximum depth of a tree
     *
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<Pair> stack = new Stack<>();
        stack.add(new Pair(root, 1));
        int result = 0;

        while (stack.size() > 0) {
            Pair pair = stack.pop();
            TreeNode node = pair.node;
            int depth = pair.depth;

            result = Math.max(result, depth);

            if (node.left != null) {
                stack.add(new Pair(node.left, depth+1));
            }
            if (node.right != null) {
                stack.add(new Pair(node.right, depth+1));
            }
        }
        return result;
    }

    /**
     * Recursive approach to find maximum depth of a tree
     */
    public int maxDepthOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepthOfTree(root.left), maxDepthOfTree(root.right));
    }
}
