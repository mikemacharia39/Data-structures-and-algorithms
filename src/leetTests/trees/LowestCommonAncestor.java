package leetTests.trees;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as
 * descendants (where we allow a node to be a descendant of itself).”
 *
 * Example 1:
 *
 *             6
 *          /    \
 *        2       8
 *      /  \    /   \
 *     0   4    7    9
 *        / \
 *       3   5
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 *
 * Example 2:
 *
 *             6
 *          /    \
 *        2       8
 *      /  \    /   \
 *     0   4    7    9
 *        / \
 *       3   5
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the
 * LCA definition.
 */
public class LowestCommonAncestor {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode (int val) {
            this.val = val;
        }
    }

    public TreeNode findLowestCA(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return findLowestCA(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return findLowestCA(root.left, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();

        System.out.print("BST: ");
        lowestCommonAncestor.print(root);

        System.out.println();

        TreeNode node = lowestCommonAncestor.findLowestCA(root, root.left, root.right);
        System.out.println("LCA of " + root.left.val + " and " + root.right.val + " is " + node.val);

        System.out.println("=================================");

        TreeNode node1 = lowestCommonAncestor.findLowestCA(root, root.left, root.left.right);
        System.out.println("LCA of " + root.left.val + " and " + root.left.right.val + " is " + node1.val);
    }

    void print(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.val + "  ");
        print(treeNode.left);
        print(treeNode.right);
    }
}
