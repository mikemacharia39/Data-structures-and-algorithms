package leettests.advanceddatastructures;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Example 1:
 *
 *
 *                   3
 *                 /   \
 *               9     20
 *                    / \
 *                   15  7
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 *
 * Example 2:
 *
 *                   1
 *                 /  \
 *               2     2
 *              / \
 *             3   3
 *            / \
 *           4   4
 *
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 *
 * Example 3:
 *
 * Input: root = []
 * Output: true
 */
public class BalancedBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {}

        public TreeNode (int val) {
            this.val = val;
        }

        public TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * https://www.programiz.com/dsa/balanced-binary-tree
     *
     * A balanced binary tree, also referred to as a height-balanced binary tree,
     * is defined as a binary tree in which the height of the left and right subtree of any node
     * differ by not more than 1.
     * Following are the conditions for a height-balanced binary tree:
     * 1. difference between the left and the right subtree for any node is not more than one
     * 2. the left subtree is balanced
     * 3. the right subtree is balanced
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int difference = Math.abs(checkHeightBalance(root.left) - checkHeightBalance(root.right));

        if (difference >= 2) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }


    private int checkHeightBalance(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftH = checkHeightBalance(root.left);
        int rightH = checkHeightBalance(root.right);

        return leftH > rightH ? leftH + 1 : rightH + 1;
    }

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // [3,9,20,null,null,15,7]

        BalancedBinaryTree isBalanced = new BalancedBinaryTree();

        System.out.println("This is preorder traversal");
        System.out.print("Tree elements: "); isBalanced.print(root);
        System.out.println();
        System.out.println("Is Balanced: " + isBalanced.isBalanced(root));
    }

    void print(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        print(root.left);
        print(root.right);
    }
}
