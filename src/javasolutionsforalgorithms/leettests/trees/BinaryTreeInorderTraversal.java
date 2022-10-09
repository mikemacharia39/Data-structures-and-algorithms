package javasolutionsforalgorithms.leettests.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">...</a>
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example 1:
 *        1
 *         \
 *           2
 *         /
 *       3
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 *
 * Example 2:
 * Input: root = []
 * Output: []
 */
public class BinaryTreeInorderTraversal {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    //================== USING RECURSION =====================

    /**
     * In order traversal -> LEFT -> ROOT -> RIGHT
     * @param root TreeNode
     * @return List
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        traverser(root, list);

        return list;
    }

    public void traverser(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        traverser(root.left, list);
        list.add(root.val);
        traverser(root.right, list);
    }

    //=================== USING STACK ===================

    /**
     * Stack can be used for inorder traversal
     * Stack is used for depth first search
     *
     * @param root TreeNode
     * @return List
     */
    public List<Integer> inorderTraversalWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);

            root = root.right;
        }

        return result;
    }
}
