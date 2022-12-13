package datastructures.trees;

public class LowestCommonAncestorOfBinaryTree {
    /**
     * There are three possible cases in this problem:
            1. If root is either 'p' or 'q'. That means, the ancestor cannot be below the root node as it would be missing the root (p or q) as a descendant
            2. If one is in the left subtree and the other in the right subtree, the lowest ancestor would be the root
            3. If both 'p' and 'q' are in one of the subtrees. In that case, the root is not the answer because we could look inside the subtree and find a "lower" node.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // first case
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // second case
        if (left != null && right != null) {
            return root;
        }

        // third case - only one of the subtrees have the two nodes
        if (left != null) {
            return left;
        }

        return right;
    }
}
