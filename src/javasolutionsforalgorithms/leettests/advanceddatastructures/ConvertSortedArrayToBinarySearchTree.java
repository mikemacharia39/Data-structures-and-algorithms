package javasolutionsforalgorithms.leettests.advanceddatastructures;

import java.util.Arrays;

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never
 * differs by more than one.
 *
 * Example 1:
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *                   0
 *                 /   \
 *               -3     5
 *              /      /
 *            -10     9
 */
public class ConvertSortedArrayToBinarySearchTree {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return toTree(nums, 0, nums.length - 1);
    }

    private TreeNode toTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end)/2;

        // 1. Assign the middle of the array to the root of the tree
        // 2. The mid is shifted
        TreeNode root = new TreeNode(nums[mid]);

        root.left = toTree(nums, start, mid-1);
        root.right = toTree(nums, mid+1, end);

        return root;
    }

    public static void main(String[] args) {

        int[] nums = {-10,-3,0,5,9};
        // Output: [0,-3,9,-10,null,5]
        // Explanation: [0,-10,5,null,-3,null,9] is also accepted:

        ConvertSortedArrayToBinarySearchTree toBinarySearchTree = new ConvertSortedArrayToBinarySearchTree();

        System.out.println("Array: " + Arrays.toString(nums));

        System.out.println("By Default traversal is in-order, i.e. root -> left -> right");
        System.out.print("BST: ");
        toBinarySearchTree.print(toBinarySearchTree.sortedArrayToBST(nums));
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
