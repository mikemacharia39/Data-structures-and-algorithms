package neetcode.tree;

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
