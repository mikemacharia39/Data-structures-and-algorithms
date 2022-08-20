package javasolutionsforalgorithms.leettests.advanceddatastructures;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the
 * farthest leaf node.
 *
 * Example 1:
 *                   3
 *                 /   \
 *               9     20
 *                    / \
 *                   15  7
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 *
 * Example 3:
 * Input: root = []
 * Output: 0
 */
public class MaximumDepthOfBinaryTree {

    /**
     * Definition for a binary tree node.
     */
    static class TreeNode {
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


    public int maxDepth(TreeNode root) {
        return maximum(root);
    }

    private int maximum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftNode = maximum(root.left);
        int rightNode = maximum(root.right);

        return Math.max(leftNode, rightNode) + 1;
    }

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // [3,9,20,null,null,15,7]

        MaximumDepthOfBinaryTree depthOfBinaryTree = new MaximumDepthOfBinaryTree();

        System.out.println("This is preorder traversal");
        System.out.print("Tree elements: ");depthOfBinaryTree.print(root);
        System.out.println();
        System.out.println("Max Depth: " + depthOfBinaryTree.maxDepth(root));
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
