package javasolutionsforalgorithms.leettests.advanceddatastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes'
 * values. (i.e., from left to right, level by level).
 *
 * Example 1:
 *                    3
 *                  /   \
 *                9     20
 *                     / \
 *                    15  7
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 */
public class BinaryTreeLevelOrderTraversal {
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


    // 1) Create an empty queue q
    // 2) temp_node = root /*start from root*/
    // 3) Loop while temp_node is not NULL
    //    a) print temp_node->data.
    //    b) Enqueue temp_node’s children
    //      (first left then right children) to q
    //    c) Dequeue a node from q.

    /**
     * Using queue)
     *
     * Algorithm:
     * For each node, first the node is visited and then it’s child nodes are put in a FIFO queue.
     *
     *
     * @param root root
     * @return list
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null){
            return list;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            List<Integer> insideList = new ArrayList<>();
            int size = nodeQueue.size();

            while (size != 0) {
                TreeNode treeNode = nodeQueue.poll();
                insideList.add(treeNode.val);

                if (treeNode.left != null) {
                    nodeQueue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nodeQueue.add(treeNode.right);
                }

                size--;
            }
            list.add(insideList);
        }

        return list;
    }

    void print(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        print(root.left);
        print(root.right);
    }

    public static void main(String[] args) {
        // Input: root = [3,9,20,null,null,15,7]
        // Output: [[3],[9,20],[15,7]]

        TreeNode root;
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversal btree = new BinaryTreeLevelOrderTraversal();
        System.out.print("Tree Elements: "); btree.print(root);

        System.out.println();
        System.out.println("List: " + btree.levelOrder(root).toString());
    }
}
