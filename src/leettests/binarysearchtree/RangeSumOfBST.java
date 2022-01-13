package leettests.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root node of a binary search tree and two integers low and high,
 * return the sum of values of all nodes with a value in the inclusive range [low, high].
 *
 * Example 1:
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 *
 *
 *                                   10
 *                                  /  \
 *                                 /    \
 *                                5     15
 *                               / \      \
 *                              /   \      \
 *                             3     7     18
 *
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 2 * 104].
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * All Node.val are unique.
 *
 */
public class RangeSumOfBST {

     static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    int sum = 0;

    /**
     * Depth-first search (DFS) is an algorithm for traversing or searching tree or
     * graph data structures. The algorithm starts at the root node (selecting
     * some arbitrary node as the root node in the case of a graph) and explores
     * as far as possible along each branch before backtracking.
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int val = 0, left = 0, right = 0;

        if (root.val >= low && root.val <= high) {
            val = root.val;
        }

        if (root.val > low) {
            left = rangeSumBST(root.left, low, high);
        }

        if (root.val < high) {
            right = rangeSumBST(root.right, low, high);
        }
        return val + left + right;
    }


    /**
     * Breadth-first search is an algorithm for searching a tree data structure
     * for a node that satisfies a given property. It starts at the tree root
     * and explores all nodes at the present depth prior to moving on to the nodes
     * at the next depth level
     */
    public int rangeSumBSTBFS(TreeNode root, int low, int high) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int sumVals = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val >= low && node.val <= high) {
                sumVals += node.val;
            }

            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
        return sumVals;
    }

    /**
     * My solution is a DFS - i.e. Traverse to all node as far as possible in  a branch before backtracking
     * My solution uses IN-ORDER traversal [L-R-R] to extract elements as they are summed
     * @param root TreeNode
     * @param low low
     * @param high high
     * @return sum
     */
    public int rangeSumBSTMySolution(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        rangeSumBST(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        rangeSumBST(root.right, low, high);

        return sum;
    }
}
