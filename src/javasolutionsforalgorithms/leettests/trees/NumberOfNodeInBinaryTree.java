package javasolutionsforalgorithms.leettests.trees;

public class NumberOfNodeInBinaryTree {

    static class Tree {
        int val;
        Tree left;
        Tree right;
        
        Tree(int val) {
            this.val = val;
        }
    }
    
    public static int countNodes(Tree tree) {
        if (tree == null) {
            return 0;
        }

        return 1 + countNodes(tree.left) + countNodes(tree.right);
    }
    
    public static void main(String[] args) {
        /**
         *            18
         *        /       \
         *      15         30
         *     /  \        /  \
         *   40    50    100   40
         *          \           \
         *          60           45
         */

        Tree tree = new Tree(18);
        tree.left = new Tree(15);
        tree.left.left = new Tree(40);
        tree.left.right = new Tree(50);
        tree.left.right.right = new Tree(60);
        tree.right = new Tree(30);
        tree.right.left = new Tree(100);
        tree.right.right = new Tree(40);
        tree.right.right.right = new Tree(40);

        System.out.println("Count Nodes: " + NumberOfNodeInBinaryTree.countNodes(tree));
    }
}
