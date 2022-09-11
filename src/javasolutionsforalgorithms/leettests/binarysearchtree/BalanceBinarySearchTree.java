package javasolutionsforalgorithms.leettests.binarysearchtree;

/**
 * <a href="https://leetcode.com/problems/balance-a-binary-search-tree/">...</a>
 *
 * Given the root of a binary search tree, return a balanced binary search tree with the same node values.
 * If there is more than one answer, return any of them.
 * A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
 *
 * Example 1:
 *       1                       2
 *        \                     / \
 *         2     ------>       1   3
 *          \                       \
 *           3                       4
 *            \
 *             4
 *
 *
 * Input: root = [1,null,2,null,3,null,4,null,null]
 * Output: [2,1,3,null,null,null,4]
 *
 * Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
 *
 */
public class BalanceBinarySearchTree {

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

    public TreeNode balanceBST(TreeNode root) {

    }

}
