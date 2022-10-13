package datastructures.trees;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
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

        System.out.println("Preorder Traversal:");
        preorder(root);
        System.out.println("\nInorder Traversal:");
        inorder(root);
        System.out.println("\nPostorder Traversal:");
        postorder(root);
    }

    private static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    private static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        inorder(root.left);
        inorder(root.right);
    }

    private static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.data + " ");
    }
}
