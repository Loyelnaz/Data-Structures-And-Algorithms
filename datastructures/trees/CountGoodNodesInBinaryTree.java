package datastructures.trees;

import java.util.Stack;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
 */
public class CountGoodNodesInBinaryTree {
    class Pair {
        TreeNode node;
        int maxSoFar;

        Pair(TreeNode node, int maxSoFar) {
            this.node = node;
            this.maxSoFar = maxSoFar;
        }
    }

    public int goodNodes(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        stack.add(new Pair(root, Integer.MIN_VALUE));
        int goodNodesCount = 0;

        while (!stack.empty()) {
            Pair pair = stack.pop();
            TreeNode node = pair.node;
            int maxSoFar = pair.maxSoFar;

            if (maxSoFar <= node.data) {
                goodNodesCount++;
            }

            maxSoFar = Math.max(maxSoFar, node.data);

            if (node.left != null) {
                stack.add(new Pair(node.left, maxSoFar));
            }
            if (node.right != null) {
                stack.add(new Pair(node.right, maxSoFar));
            }
        }

        return goodNodesCount;
    }
}
