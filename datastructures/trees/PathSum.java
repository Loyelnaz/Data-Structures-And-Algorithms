package datastructures.trees;

import java.util.Stack;

/**
 * Leetcode - https://leetcode.com/problems/path-sum/description/
 */
public class PathSum {
    class Pair {
        TreeNode node;
        int sum;

        Pair(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }

    public boolean pathSum(TreeNode root, int target) {
        return pathSum(root, target, 0);
    }

    public boolean pathSum(TreeNode root, int target, int sum) {
        if (root == null) {
            return false;
        }

        sum = sum + root.data;
        if (root.left == null && root.right == null) {
            return (target == sum);
        }

        boolean result = pathSum(root.left, target, sum);
        if (!result) {
            result = pathSum(root.right, target, sum);
        }

        return result;
    }


    /**
     * Iterative approach to path sum from root to leaf node
     *
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Stack<Pair> stack = new Stack<>();
        stack.add(new Pair(root, root.data));

        while (stack.size() > 0) {
            Pair pair = stack.pop();
            TreeNode node = pair.node;
            int sum = pair.sum;

            if (node.left == null && node.right == null) {
                if (sum == targetSum) {
                    return true;
                }
            }

            if (node.left != null) {
                stack.add(new Pair(node.left, sum + node.left.data));
            }
            if (node.right != null) {
                stack.add(new Pair(node.right, sum + node.right.data));
            }
        }

        return false;
    }
}
