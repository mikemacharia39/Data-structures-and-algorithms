package javasolutionsforalgorithms.hackerrank.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem">...</a>
 *
 * The height of a binary tree is the number of edges between the tree's root and its furthest leaf.
 * For example, the following binary tree is of height 2:
 *                  4
 *                /   \
 *               2     6
 *             / \    / \
 *            1   3   5  7
 *
 * Function Description
 * ----------------------
 *
 * Complete the getHeight or height function in the editor. It must return the height of a binary tree as an integer.
 *
 * getHeight or height has the following parameter(s):
 *
 * root: a reference to the root of a binary tree.
 *
 * Note -The Height of binary tree with single node is taken as zero. The tree expects at least one node
 *
 * Output Format
 *
 * Your function should return a single integer denoting the height of the binary tree.
 *
 */
public class HeightOfABinaryTree {
    static class Node {
        Node right;
        Node left;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Using Queue: We use queue for level order traversal
     * @param root Node
     * @return height
     */
    public static int height(Node root) {
        Queue<Node> queue = new LinkedList<>();
        int counter = -1;
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                Node node = queue.poll();
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                size--;
            }
            ++counter;
        }
        return counter;
    }

    /**
     * Using recursion to calculate height of BST
     * @param root Node
     * @return height
     */
    public static int height_recursive(Node root) {
        if (root == null) {
            return -1;
        }

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right)+1;
    }
}
