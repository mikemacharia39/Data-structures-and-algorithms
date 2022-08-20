package javasolutionsforalgorithms.neetcode.tree;

/**
 * 230. Kth Smallest Element in a BST
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 *
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 *
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations)
 * and you need to find the kth smallest frequently, how would you optimize?
 */

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {
    static class TreeNode{
        TreeNode left;
        TreeNode right;

        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        List<Integer> list = new ArrayList<>();
        public int kthSmallest(TreeNode root, int k) {

            helper(root);

            return list.get(k-1);
        }

        public void helper(TreeNode root) {
            if (root == null) {
                return;
            }

            helper(root.left);
            list.add(root.val);
            helper(root.right);
        }
    }

    class Solution2 {
        int counter = 0;
        int val;
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
    }
}
