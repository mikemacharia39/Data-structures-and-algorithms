package javasolutionsforalgorithms.leettests.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition of different type of trees
 * <a href="https://cs.stackexchange.com/questions/32397/is-there-a-difference-between-perfect-full-and-complete-tree">...</a>
 * Yes, there is a difference between the three terms and the difference can be explained as:
 *
 * Full Binary Tree: A Binary Tree is full if every node has 0 or 2 children. Following are examples of a full binary tree.
 *
 *          18
 *        /    \
 *      15      20
 *     /  \
 *    40   50
 *   /  \
 *  30  50
 *
 *
 * Complete Binary Tree: A Binary Tree is complete Binary Tree if all levels are completely filled except possibly the last level and the last level has all keys as left as possible.
 *
 *             18
 *        /         \
 *      15           30
 *     /  \         /  \
 *   40    50     100   40
 *  /  \   /
 * 8   7  9
 *
 *
 *
 * Perfect Binary Tree: A Binary tree is Perfect Binary Tree in which all internal nodes have two children and all
 * leaves are at same level.
 *
 *            18
 *        /       \
 *      15         30
 *     /  \        /  \
 *   40    50    100   40
 *
 *
 *
 * QUESTION
 * -------------------
 * Find largest perfect subtree from binary tree provided below
 *
 *                     1                                              3
 *                 /      \                                         /  \
 *                2        3                                       5    6
 *                 \      /  \            =>                     /  \  /  \
 *                  4   5     6                                 7   8 9   10
 *                    /  \   /  \
 *                   7    8  9  10
 *                              /
 *                             11
 *
 * resources:
 * https://www.geeksforgeeks.org/find-the-largest-perfect-subtree-in-a-given-binary-tree/
 * https://www.geeksforgeeks.org/check-weather-given-binary-tree-perfect-not/
 * https://www.techiedelight.com/convert-given-binary-tree-to-full-tree-removing-half-nodes/
 */

public class PerfectBinaryTreeStructure {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class TreeStructure {
        boolean isPerfect;
        int height;
        TreeNode treeNode;
    }

    /**
     * Perfect Binary Tree: A Binary tree is Perfect Binary Tree in which all internal nodes have two children and all
     * leaves are at same level.
     * The operations involved:
     * 1. Make tree full binary tree
     * 2. Check for largest perfect tree inside the full tree
     *
     * @param root TreeNode
     * @return TreeNode
     */
    public static TreeNode perfectTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode fullSubTree = makeTreeFull(root);

        return createPerfectTree(fullSubTree).treeNode;
    }

    /**
     * Making a tree full is essential to making a tree perfect
     * The idea being, a Binary Tree is full if every node has 0 or 2 children. This way we are able
     * to exclude all node that are not full
     *
     * @param node TreeNode
     * @return TreeNode
     */
    private static TreeNode makeTreeFull(TreeNode node) {
        if (node == null) {
            return null;
        }

        node.left = makeTreeFull(node.left);
        node.right = makeTreeFull(node.right);

        if ((node.right != null && node.left != null) || isLeaf(node)) {
            return node;
        } else {
            node.left = null;
            node.right = null;
        }

        return node;
    }

    /**
     *
     * @param root TreeNode
     * @return TreeNode
     */
    private static TreeStructure createPerfectTree(TreeNode root) {
        TreeStructure ts = new TreeStructure();

        // empty tree is perfect
        if (root == null) {
            ts.treeNode = null;
            ts.isPerfect = true;
            ts.height = 0;
            return ts;
        }

        TreeStructure leftSide = createPerfectTree(root.left);
        TreeStructure rightSide = createPerfectTree(root.right);

        if (leftSide.isPerfect && rightSide.isPerfect && leftSide.height == rightSide.height) {
            ts.treeNode = root;
            ts.isPerfect = true;
            ts.height = rightSide.height + 1;

            return ts;
        }

        ts.isPerfect = false;
        ts.height = Math.max(leftSide.height, rightSide.height);
        ts.treeNode = (leftSide.height > rightSide.height ? leftSide.treeNode : rightSide.treeNode);

        return ts;
    }


    /**
     * If a node neither has left nor right subtree
     * @param node TreeNode
     * @return true|false
     */
    public static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    // preorder -> ROOT LEFT RIGHT
    public static void print(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        res.add(node.val);
        print(node.left, res);
        print(node.right, res);
    }

    public static void main(String[] args) {
        /**
         *                     1
         *                 /      \
         *                2        3
         *                 \      /  \
         *                  4   5     6
         *                    /  \   /  \
         *                   7    8  9  10
         *                              /
         *                             11
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);

        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);
        root.right.right.right.right = new TreeNode(11);

        List<Integer> res = new ArrayList<>();
        print(root, res);
        System.out.println("Original Tree: " + res);


        TreeNode resultTree = perfectTree(root);
        List<Integer> ans = new ArrayList<>();
        print(resultTree, ans);
        System.out.println("Perfect Tree: " + ans);
    }
}
