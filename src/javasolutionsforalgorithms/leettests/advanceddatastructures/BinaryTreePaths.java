package javasolutionsforalgorithms.leettests.advanceddatastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 *
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * A leaf is a node with no children.
 *
 * Example 1:
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 *
 * Example 2:
 * Input: root = [1]
 * Output: ["1"]
 */
public class BinaryTreePaths {
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        
        if (root.left==null && root.right==null) {
            list.add(Integer.toString(root.val));
            return list;
        }

        for (String s: binaryTreePaths(root.left)) {
            list.add(Integer.toString(root.val)+"->"+s);
        }
        for (String s: binaryTreePaths(root.right)) {
            list.add(Integer.toString(root.val)+"->"+s);
        }

        return list;
    }

    public static void main(String[] args) {

        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(3);

        // Input: root = [1,2,3,null,5]
        // Output: ["1->2->5","1->3"]

        BinaryTreePaths treePaths = new BinaryTreePaths();

        List<String> ans = treePaths.binaryTreePaths(root);

        System.out.println("Ans: " + ans.toString());
    }
}
