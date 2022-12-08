package javasolutionsforalgorithms.leettests.trees;

/**
 * A Perfect Binary Tree of height h (where height is number of nodes on path from root to leaf) has 2^h – 1 nodes.
 */
public class NumberOfNodesInPerfectTree {
    static class Tree {
        int val;
        Tree left;
        Tree right;

        Tree(int val) {
            this.val = val;
        }
    }

    // 2^h - 1
    public int countNodes(Tree tree) {
        int depth = 0;
        while (tree != null) {
            depth++;
            tree = tree.left;
        }

        return (int) Math.pow(2, depth) - 1;
    }

    public static void main(String[] args) {
        /**
         *            18
         *        /       \
         *      15         30
         *     /  \        /  \
         *   40    50    100   40
         */

        Tree tree = new Tree(18);
        tree.left = new Tree(15);
        tree.left.left = new Tree(40);
        tree.left.right = new Tree(50);
        tree.right = new Tree(30);
        tree.right.left = new Tree(100);
        tree.right.right = new Tree(40);

        NumberOfNodesInPerfectTree nodesInPerfectTree = new NumberOfNodesInPerfectTree();

        System.out.println("Number of nodes: " + nodesInPerfectTree.countNodes(tree));
    }
}
