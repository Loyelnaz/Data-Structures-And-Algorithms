package datastructures.trees;

import java.util.Stack;

/**
 * Given the root of a binary tree and an integer targetSum,
 * return true if there exists a path from the root to a leaf such that
 * the sum of the nodes on the path is equal to targetSum, and return false otherwise.
 *
 * Leetcode - https://leetcode.com/problems/path-sum/description/
 */
public class PathSum {
    static class Pair {
        TreeNode node;
        int sum;

        Pair(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode leftChildLevelOne = new TreeNode(2);
        TreeNode rightChildLevelOne = new TreeNode(3);

        root.left = leftChildLevelOne;
        root.right = rightChildLevelOne;

        TreeNode leftChildLevelTwo = new TreeNode(4);
        TreeNode rightChildLevelTwo = new TreeNode(5);

        rightChildLevelOne.left = leftChildLevelTwo;
        rightChildLevelOne.right = rightChildLevelTwo;

        System.out.println(pathSum(root, 8));
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public static boolean pathSum(TreeNode root, int target) {
        return pathSum(root, target, 0);
    }

    public static boolean pathSum(TreeNode root, int target, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return (target == sum + root.data);
        }

        sum += root.data;
        boolean left = pathSum(root.left, target, sum);
        boolean right = pathSum(root.right, target, sum);

        return left || right;
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
