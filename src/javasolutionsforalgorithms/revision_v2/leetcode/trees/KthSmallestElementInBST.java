package javasolutionsforalgorithms.revision_v2.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/">...</a>
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of
 * all the values of the nodes in the tree.
 */
public class KthSmallestElementInBST {

    int counter = 0;
    int val;

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
    }

    /**
     * To find the kth smallest element in a BST, we can do an inorder traversal and then return the kth element
     * Elements in a BST are sorted in an inorder traversal
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest1(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        List<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);
        return nodes.get(k - 1);
    }

    private void inorder(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        inorder(root.left, nodes);
        nodes.add(root.val);
        inorder(root.right, nodes);
    }

    public int kthSmallest(TreeNode root, int k) {

        help(root, k);

        return val;
    }

    public void help(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        help(root.left, k);
        counter++;
        if (counter == k) {
            val = root.val;
            return;
        }
        help(root.right, k);
    }

    public static void main(String[] args) {
        KthSmallestElementInBST obj = new KthSmallestElementInBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.left.right = new TreeNode(4);
        System.out.println(obj.kthSmallest(root, 4));
    }
}
