package javasolutionsforalgorithms.leettests.binarysearchtree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Given the root of a Binary Search Tree and a target number k,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 *              5
 *            /   \
 *           3     6
 *         /  \      \
 *        2   4       7
 * Input: root = [5,3,6,2,4,null,7], k = 9
 * Output: true
 */
public class TwoSumIVInputIsABST {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }


    public boolean findTarget_usingStack(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if (set.contains(k - root.val)) {
                return true;
            } else {
                set.add(root.val);
            }
            root = root.right;
        }

        return false;
    }
}
