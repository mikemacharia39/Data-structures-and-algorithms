package javasolutionsforalgorithms.revision_v2.leetcode.trees;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is
 * the inorder traversal of the same tree, construct and return the binary tree.
 *
 * Example 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createBSTTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode createBSTTree(int[] preorder, int[] inorder, int startPreorder, int startInorder, int endInorder) {
        if (startPreorder > preorder.length - 1 || startInorder > endInorder) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[startPreorder]);
        int index = 0;
        for (int i = startInorder; i <= endInorder; i++) {
            if (inorder[i] == root.val) {
                index = i;
            }
        }

        root.left = createBSTTree(preorder, inorder, startPreorder + 1, startInorder, index - 1);
        root.right = createBSTTree(preorder, inorder, startPreorder + index - startInorder + 1, index + 1, endInorder);
        return root;
    }

    private void print(TreeNode root) {
        if (root == null) {
            return;
        }
        print(root.left);

        System.out.println(root.val);

        print(root.right);
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal obj = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode root = obj.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        obj.print(root);
    }
}
