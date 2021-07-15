package leetTests.advanceddatastructures;

import java.util.HashSet;

/**
 * Given the root of a Binary Search Tree and a target number k,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 *
 *                   5
 *                 /   \
 *               3      6
 *              / \      \
 *             2   4      7
 * Input: root = [5,3,6,2,4,null,7], k = 9
 * Output: true
 *
 * Example 2:
 * Input: root = [2,1,3], k = 4
 * Output: true, because 3+1 = 4
 *
 * Example 3:
 * Input: root = [2,1,3], k = 1
 * Output: false, there are no two values when added can sum to 1
 *
 * Example 4:
 * Input: root = [2,1,3], k = 3
 * Output: true, because 2 + 1 = 3
 */
public class TwoSumIVInputIsBinarySearchTree {
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

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int sum = 9;

        TwoSumIVInputIsBinarySearchTree sumIVInputIsBinarySearchTree = new TwoSumIVInputIsBinarySearchTree();

        System.out.print("BST Elements: ");
        sumIVInputIsBinarySearchTree.print(root);
        System.out.println();

        System.out.println("Has sum: " + sumIVInputIsBinarySearchTree.findTarget(root, sum));
    }

    void print(TreeNode root) {
         if (root == null) {
             return;
         }
         print(root.left);
         System.out.print(root.val + " ");
         print(root.right);
    }

    /**
     * Complexity Analysis
     * Time complexity : O(n). The entire tree is traversed only once in the worst case.
     * Here, n refers to the number of nodes in the given tree.
     * Space complexity : O(n). The size of the set can grow upto nn in the worst case.
     */
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();

        return find(root, k, set);
    }

    private boolean find(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }
        
        if (set.contains(k - root.val)) {
            return true;
        } else {
            set.add(root.val);
        }

        return find(root.left, k, set) || find(root.right, k, set);
    }
}
