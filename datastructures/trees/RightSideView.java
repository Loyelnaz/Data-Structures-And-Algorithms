package datastructures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */
public class RightSideView {

    // Definition for a binary tree node.
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    class Solution {
        /**
         * This can be solved using BFS tree traversal
         */
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                TreeNode node = null;

                for (int i = 0; i < size; i++) {
                    node = queue.poll();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }

                if (node != null) {
                    // add the node that was last visited
                    result.add(node.val);
                }
            }

            return result;
        }
    }
}
