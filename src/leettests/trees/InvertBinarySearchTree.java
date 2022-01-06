package leettests.trees;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Example 1:
 *
 *               4
 *            /    \
 *           2      7
 *         /  \    /  \
 *       1     3  6    9
 *
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 *
 * NB/
 * Depth First Traversals:
 *
 *              1
 *            /  \
 *           2    3
 *         /  \
 *        4    5
 *
 * (a) Inorder (Left, Root, Right) : 4 2 5 1 3
 * (b) Preorder (Root, Left, Right) : 1 2 4 5 3
 * (c) Postorder (Left, Right, Root) : 4 5 2 3 1
 * Breadth-First or Level Order Traversal: 1 2 3 4 5
 * Please see this post for Breadth-First Traversal.
 *
 */
public class InvertBinarySearchTree {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Use recursion to invert tree
     * 1. check if root is null if not null
     * 2. assign values of left to right of the tree and vise-versa
     *
     * @param root TreeNode
     * @return inverted tree
     */
    public TreeNode invertBinaryTree(TreeNode root) {

        if (root == null) {
            return root;
        }

        TreeNode temp = root.right;

        root.right = invertBinaryTree(root.left);
        root.left = invertBinaryTree(temp);

        return root;
    }

    void print(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + ", ");
            print(root.left);
            print(root.right);
        }
    }


    public static void main(String[] args) {
        // [4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        InvertBinarySearchTree invertBinarySearchTree = new InvertBinarySearchTree();

        System.out.println("Original: ");

        invertBinarySearchTree.print(root);

        System.out.println("\nInverted: ");

        invertBinarySearchTree.print(invertBinarySearchTree.invertBinaryTree(root));
    }
}
