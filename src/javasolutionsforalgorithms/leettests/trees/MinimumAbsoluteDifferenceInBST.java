package javasolutionsforalgorithms.leettests.trees;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference
 * between the values of any two different nodes in the tree.
 *            4
 *          /  \
 *         2    6
 *        / \
 *       1   3
 *
 * Input: root = [4,2,6,1,3]
 * Output: 1
 */
public class MinimumAbsoluteDifferenceInBST {

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

    private TreeNode prev;
    private int min = Integer.MAX_VALUE;

    public int minimumDifference(TreeNode root) {
        if (root == null) {
            return min;
        }

        minimumDifference(root.left);
        if (prev != null) {
            min = Math.min(min, Math.abs(root.val - prev.val));
        }
        prev = root;
        minimumDifference(root.right);

        return min;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right = new TreeNode(6);

        MinimumAbsoluteDifferenceInBST minimumAbsoluteDifferenceInBST = new MinimumAbsoluteDifferenceInBST();

        Logger.getLogger(MinimumAbsoluteDifferenceInBST.class.getName())
                .log(Level.INFO, "Minimum difference is {0}", minimumAbsoluteDifferenceInBST.minimumDifference(treeNode));
    }
}
