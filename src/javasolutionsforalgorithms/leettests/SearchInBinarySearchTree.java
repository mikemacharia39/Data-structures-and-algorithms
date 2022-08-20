package javasolutionsforalgorithms.leettests;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
 * If such a node does not exist, return null.
 *
 */

public class SearchInBinarySearchTree {

    public static void main(String[] args) {

//        Input: root = [4,2,7,1,3], val = 2
//        Output: [2,1,3]
//        A binary search tree
//        Binary Search Tree is a node-based binary tree data structure which has the following properties:
//        The left subtree of a node contains only nodes with keys lesser than the node’s key.
//                  4
//                /   \
//              2     7
//             / \
//            1   3


        TreeNode root = new TreeNode();
        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);

        SearchInBinarySearchTree searchInBinarySearchTree = new SearchInBinarySearchTree();
        TreeNode ans = searchInBinarySearchTree.searchBST(root, 2);

        searchInBinarySearchTree.print(ans);
    }

    void print(TreeNode ans) {

        if (ans == null) {
            return;
        }

        print(ans.right);
        System.out.print(ans.val + ", ");
        print(ans.left);
    }

    public TreeNode searchBST(TreeNode root, int val) {

        while (root != null && root.val != val) {

            if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }

        }

        return root;
    }
}
