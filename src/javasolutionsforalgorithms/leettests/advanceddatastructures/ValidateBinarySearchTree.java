package javasolutionsforalgorithms.leettests.advanceddatastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 * Input: root = [2,1,3]
 * Output: true
 *
 * Example 2:
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {

    TreeNode prev;

    public class TreeNode {
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

    //============= USE A STACK TO DETERMINE IF IS BST =====================

    /**
     * Use a stack and traverse through the TreeNode in order traversal i.e. LEFT->ROOT->RIGHT
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode previous = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if (previous != null && root.val <= previous.val) {
                return false;
            }
            previous = root;

            root = root.right;
        }

        return true;
    }

    //======================= USE A LIST TO CHECK IF IS BST ==============================

    /**
     * Add the items to a list using in order traversal i.e. LEFT -> ROOT -> RIGHT
     * Check if the list is sorted
     * @param root TreeNode
     * @return true|false
     */
    public boolean isValidBSTUsingList(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        addToList(root, list);

        if (list.size() < 2) {return true;}
        int previous = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (previous >= list.get(i)) {
                return false;
            }
            previous = list.get(i);
        }

        return true;
    }

    /**
     * Add items to list in order traversal
     * Then check if list is sorted
     */
    void addToList(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        addToList(root.left, list);
        list.add(root.val);
        addToList(root.right, list);
    }


    //====================== ANOTHER WAY TO USE RECURSION TO CHECK IF IS BST =======================

    boolean checkBST(TreeNode root) {
        if (root == null) {return true;}
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.val >= max || root.val <= min) {
            return false;
        }

        // why we do this?
        // on the left side this compares min and root.val, values on the left must be smaller
        // than the root, that is why when traversing on left we assign max the root val
        // on the right this compares root to max.val, values on the right must be greater than the root
        // comparison is against root.val and max

        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

    //======================= USE RECURSION TO VALIDATE IF IS BST ==============================

    public boolean isValidBSTUsingRecursion(TreeNode root) {
        prev = null;

        return isBST(root);
    }

    private boolean isBST(TreeNode root) {
        if (root != null) {

            if (!isBST(root.left)) {
                return false;
            }

            if (prev != null && root.val <= prev.val) {
                return false;
            } else {
                prev = root;
            }

            return isBST(root.right);
        } else {
            return true;
        }
    }
}
