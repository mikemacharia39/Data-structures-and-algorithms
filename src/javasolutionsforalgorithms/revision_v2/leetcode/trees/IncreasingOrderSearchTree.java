package javasolutionsforalgorithms.revision_v2.leetcode.trees;

/**
 * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now
 * the root of the tree, and every node has no left child and only one right child.
 *
 * Example 1:
 * Input: root = [5,1,7]
 * Output: [1,null,5,null,7]
 *
 *      5                        1
 *    /   \           =>           \
 *   1     7                        5
 *                                    \
 *                                     7
 */
public class IncreasingOrderSearchTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
    }
}
