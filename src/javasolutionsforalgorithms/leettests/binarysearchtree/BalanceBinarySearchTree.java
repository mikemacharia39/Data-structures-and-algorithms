package javasolutionsforalgorithms.leettests.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * the idea is to convert the treeNode to a sorted array, by using inorder traversal
     * then recursively create a tree from the array
     * @param root TreeNode
     * @return BST
     */
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        toArray(list, root);

        return toTree(list, 0, list.size()-1);
    }

    public TreeNode toTree(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end)/2;

        TreeNode root = new TreeNode(list.get(mid));

        root.left = toTree(list, start, mid-1);
        root.right = toTree(list, mid+1, end);

        return root;
    }

    /**
     * Inorder traversal  LEFT -> ROOT -> RIGHT
     * @param list list
     * @param root root
     */
    public void toArray(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        toArray(list, root.left);
        list.add(root.val);
        toArray(list, root.right);
    }


    public void preOrderTraverse(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrderTraverse(list, root.left);
        preOrderTraverse(list, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        BalanceBinarySearchTree balanceBinarySearchTree = new BalanceBinarySearchTree();

        TreeNode ansBST = balanceBinarySearchTree.balanceBST(root);

        List<Integer> resultTreeList = new ArrayList<>();

        balanceBinarySearchTree.preOrderTraverse(resultTreeList, ansBST);

        System.out.printf("Converted BST: %s%n", resultTreeList);
    }
}
