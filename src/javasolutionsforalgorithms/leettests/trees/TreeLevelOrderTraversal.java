package javasolutionsforalgorithms.leettests.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://www.hackerrank.com/challenges/tree-level-order-traversal/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign">...</a>
 *
 * Given a pointer to the root of a binary tree, you need to print the level order traversal of this tree.
 * In level-order traversal, nodes are visited level by level from left to right.
 * Complete the function levelOrder and print the values in a single line separated by a space.
 *
 * For example:
 *
 *      1
 *       \
 *        2
 *         \
 *          5
 *         /  \
 *        3    6
 *         \
 *          4
 * For the above tree, the level order traversal is 1 -> 2 -> 5 -> 3 -> 6 -> 4.
 *
 * Input Format
 *
 * You are given a function,
 *
 * void levelOrder(Node * root) {
 *
 * }
 *
 *
 */
public class TreeLevelOrderTraversal {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qsize = queue.size();
            while(qsize != 0) {
                Node node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                System.out.print(node.data);
                if (qsize > 0) {
                    System.out.print(" ");
                }

                qsize--;
            }
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
}
