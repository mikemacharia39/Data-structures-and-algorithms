package leettests.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * You are given a non-null array of integers. Implement the method arrayToTree which creates a binary tree from its values in accordance to their order, while creating nodes by depth from left to right.
 *
 * For example, given the array [17, 0, -4, 3, 15] you should create the following tree:
 *              17
 *             / \
 *            0   -4
 *          /  \
 *         3    15
 *
 */
public class ArrayToTreeConversion {
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

    /**
     * Usually population of tree data is based on Level order traversal
     * @param arr data
     * @return tree
     */
    public TreeNode arrayToTree(int[] arr) {
        return arrayToTree(arr, 0);
    }

    /**
     * You might ask, why do we do 2 * index + 1 or 2 * index + 2
     * Population of the data starts from root, therefore position starts from 0, then
     * left node is assigned (2 * 0) + 1 = 1
     * right node is assigned (2 * 0) + 2 = 2
     * left-left node is assigned (2 * 1) + 1 = 3
     * right-right node is assigned (2 * 1) + 2 = 4  and so on and so forth
     *
     * Also the index can be assumed to represent the levels
     *
     * @param arr array
     * @param index index
     * @return tree
     */
    public TreeNode arrayToTree(int[] arr, int index) {
        if (index >= arr.length) {
            return null;
        }

        return new TreeNode(arr[index], arrayToTree(arr, (index * 2) + 1), arrayToTree(arr, (index * 2) + 2));
    }

    public List<Integer> toListDFT(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        return toListDFT(root, list);
    }

    public List<Integer> toListDFT(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }

        list.add(root.val);
        toListDFT(root.left, list);
        toListDFT(root.right, list);

        return list;
    }


    public static void main(String[] args) {

        int[] numbers = {17, 0, -4, 3, 15};

        ArrayToTreeConversion arrayToTreeConversion = new ArrayToTreeConversion();

        TreeNode resultTree = arrayToTreeConversion.arrayToTree(numbers);

        Object[] objects = {Arrays.toString(numbers), arrayToTreeConversion.toListDFT(resultTree)};

        Logger.getLogger(ArrayToTreeConversion.class.getName())
                .log(Level.INFO, "Original array {0} and converted tree {1}", objects);
    }
}
