package javasolutionsforalgorithms.leettests.trees;


/**
 * Perfect Binary Tree: A Binary tree is Perfect Binary Tree in which all internal nodes have two children and all
 * leaves are at same level.
 *
 *            18
 *        /       \
 *      15         30
 *     /  \        /  \
 *   40    50    100   40
 */
public class CheckIfTreeIsPerfect {

    static class Tree {
        int val;
        Tree left;
        Tree right;

        Tree(int val) {
            this.val = val;
        }
    }


    //https://www.geeksforgeeks.org/check-weather-given-binary-tree-perfect-not/
    public boolean isPerfectTree(Tree root) {
        int depth = treeDepth(root);

        return isPerfectTree(root, depth, 0);
    }

    private boolean isPerfectTree(Tree root, int depth, int currentLevel) {
        // by default an empty tree is perfect. this is also the terminating condition
        if (root == null) {
            return true;
        }

        //since this is a recursive function, when depth is equal to currentLevel+1 then it is perfect
        if (root.left == null && root.right == null) {
            return depth == currentLevel + 1; // +1 because it is one level deeper
        }

        // if either node is null, it is not perfect
        if (root.left == null || root.right == null) {
            return false;
        }

        return isPerfectTree(root.left, depth, currentLevel+1) && isPerfectTree(root.right, depth, currentLevel+1);
    }

    /**
     * Find the longest path/number of edges from root node to leaf node
     * @param node Tree
     * @return depth
     */
    private int treeDepth(Tree node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

    public static void main(String[] args) {
        CheckIfTreeIsPerfect checkIfTreeIsPerfect = new CheckIfTreeIsPerfect();
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

        System.out.println("Is perfect tree: " + checkIfTreeIsPerfect.isPerfectTree(tree));

        /**
         *            18
         *        /       \
         *      15         30
         *     /           /  \
         *   40          100   40
         */

        Tree tree2 = new Tree(18);
        tree2.left = new Tree(15);
        tree2.left.left = new Tree(40);
        tree2.right = new Tree(30);
        tree2.right.left = new Tree(100);
        tree2.right.right = new Tree(40);

        System.out.println("Is perfect tree: " + checkIfTreeIsPerfect.isPerfectTree(tree2));
    }
}