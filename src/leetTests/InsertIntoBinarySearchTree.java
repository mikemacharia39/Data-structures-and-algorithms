package leetTests;

/**
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 *
 * Notice that there may exist multiple valid ways for the insertion, as long as the
 * tree remains a BST after insertion. You can return any of them.
 *
 * Example 1:
 * Input: root = [4,2,7,1,3], val = 5
 * Output: [4,2,7,1,3,5]
 *
 * Concepts about binary search tree
 * Binary Search Tree is a node-based binary tree data structure which has the following properties:
 *
 * The left subtree of a node contains only nodes with keys lesser than the node’s key.
 * The right subtree of a node contains only nodes with keys greater than the node’s key.
 * The left and right subtree each must also be a binary search tree.
 *
 */

/**
 * Definition for a binary tree node.
 */
class TreeNode {
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


public class InsertIntoBinarySearchTree {

    public static void main(String[] args) {
        InsertIntoBinarySearchTree intoBinarySearchTree = new InsertIntoBinarySearchTree();

        // [4,2,7,1,3], val = 5

        TreeNode root = new TreeNode();
        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);

        TreeNode ans = intoBinarySearchTree.insertIntoBST(root, 5);

        intoBinarySearchTree.print(ans);
    }

    void print(TreeNode ans) {
        if (ans == null) {
            return;
        }

        print(ans.left);
        System.out.println(ans.val);
        print(ans.right);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val >= val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}
