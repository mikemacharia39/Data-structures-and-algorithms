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

        return (int) Math.pow(2,depth) - 1;
    }
}
