package javasolutionsforalgorithms.leettests.advanceddatastructures;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 *
 * Example 2:
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 *
 */
public class MinimumDepthOfBinaryTree {
    /**
     Definition for a binary tree node.
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

    /**
     * Logic here is that if you find a node with either of right or left is absent, return the maximum of left/right
     * because one of them is 0 anyway.
     * @param root root
     * @return min
     */
    public int minDepthSln1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        int min = (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;

        return min;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;

        if (root.left != null && root.right != null) {
            depth = Math.min(minDepth(root.left), minDepth(root.right));
        } else if (root.left != null) {
            depth = minDepth(root.left);
        } else if (root.right != null) {
            depth = minDepth(root.right);
        }

        return depth + 1;
    }
}
