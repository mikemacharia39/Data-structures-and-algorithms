package javasolutionsforalgorithms.revision_v2.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">...</a>
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 * Example 1:
 *              1
 *                \
 *                 2
 *                /
 *               3
 *
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 */
public class BinaryTreePostorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
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
     * Postorder traversal is LEFT -> RIGHT -> ROOT
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        traverse(root, list);

        return list;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traverse(root.left, list);
        traverse(root.right, list);
        list.add(root.val);
    }

    private void insertElement(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (val < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertElement(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertElement(root.right, val);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreePostorderTraversal obj = new BinaryTreePostorderTraversal();
        TreeNode root = new TreeNode(5);
        obj.insertElement(root, 7);
        obj.insertElement(root, 8);
        obj.insertElement(root, 9);
        obj.insertElement(root, 2);
        obj.insertElement(root, 1);
        obj.insertElement(root, 4);
        obj.insertElement(root, 3);
        obj.insertElement(root, 6);
        List<Integer> list = obj.postorderTraversal(root);
        System.out.println(list);
    }
}
