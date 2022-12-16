package javasolutionsforalgorithms.leettests.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Complete Binary Tree: A Binary Tree is complete Binary Tree if all levels are completely filled except 
 * possibly the last level and the last level has all keys as left as possible.
 *
 *             18
 *        /         \
 *      15           30
 *     /  \         /  \
 *   40    50     100   40
 *  /  \   /
 * 8   7  9
 * 
 */
public class ExtractCompleteSubTreeFromTree {
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
     *
     * // NB: THIS IS NOT THE COMPLETE SOLUTION
     *
     * Perfect Binary Tree: A Binary tree is Perfect Binary Tree in which all internal nodes have two children and all
     * leaves are at same level.
     * @param root TreeNode
     * @return TreeNode
     */
    public static TreeNode completeSubTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        return truncateTree(root);
    }


    /**
     *
     * @param root TreeNode
     * @return TreeNode
     */
    private static TreeNode truncateTree(TreeNode root) {
        // empty tree is complete tree
        if (root == null) {
            return null;
        }

        root.left = truncateTree(root.left);
        root.right = truncateTree(root.right);

        if ((root.left != null && root.right != null) || isLeaf(root)) {
            return root;
        } else {
            root.left = null;
            root.right = null;
        }

        return root;
    }
    
    /**
     * If a node neither has left nor right subtree
     * @param node TreeNode
     * @return true|false
     */
    public static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    // preorder -> ROOT LEFT RIGHT
    public static void print(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        res.add(node.val);
        print(node.left, res);
        print(node.right, res);
    }

    public static void main(String[] args) {
        /**
         *                     1
         *                 /      \
         *                2        3
         *                 \      /  \
         *                  4   5     6
         *                    /  \   /  \
         *                   7    8  9  10
         *                              /
         *                             11
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);

        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);
        root.right.right.right.right = new TreeNode(11);

        List<Integer> res = new ArrayList<>();
        print(root, res);
        System.out.println("Original Tree: " + res);


        TreeNode resultTree = completeSubTree(root);
        List<Integer> ans = new ArrayList<>();
        print(resultTree, ans);
        System.out.println("Perfect Tree: " + ans);
    }
}
