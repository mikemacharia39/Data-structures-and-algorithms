package javasolutionsforalgorithms.leettests.binarysearchtree;

import java.util.*;

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

    /**
     * Using recursion
     * @param root TreeNode
     * @param k K
     * @return true|false
     */
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    /**
     * pre order root -> left -> right
     */
    public boolean find(TreeNode root, int k, Set<Integer> set) {
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

    public boolean findTarget_usingQueue(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            int qSize = queue.size();

            while (qSize > 0) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                if (set.contains(k - node.val)) {
                    return true;
                } else {
                    set.add(node.val);
                }

                qSize--;
            }

        }

        return false;
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
