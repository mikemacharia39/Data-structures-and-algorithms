package javasolutionsforalgorithms.revision_v2.general.dynamic_programming;

/**
 * Given a 2d matrix, find the maximum sum, given that you can only check the difference between adjacent elements to the right and bottom or diagonally right. The starting point can be anywhere provided you are able to get the max difference. e.g.
 *
 * [
 * [7, 4, 5],
 * [8, 2, 1]
 * ]
 * Starting at [0, 0], In the below the maximum sum is -1 because 8 - 7 = 1
 *
 * Example 2:
 * [
 * [7, 2, 5],
 * [6, 15, 6],
 * [6, 9, 3],
 * [2, 8, 16]
 * ]
 * Starting at [0,1], the maximum size is 14, because, [15 - 2 = 13] + [9 - 15 = 6] + [16 - 9 = 7] = 14
 *
 * The maximum sum is the difference between any of the elements to the right, bottom or diagonally right.
 */
public class MaxPathSum {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {7, 4, 5},
                {8, 2, 1}
        };
        int[][] matrix2 = {
                {7, 2, 5},
                {6, 15, 6},
                {6, 9, 3},
                {2, 8, 16}
        };
        int[][] matrix3 = {
                {7, 5, 4},
                {6, 3, 1}
        };

        System.out.println("Max sum for matrix1: " + findMaxSum(matrix1)); // Output should be 1
        System.out.println("Max sum for matrix2: " + findMaxSum(matrix2)); // Output should be 14
        System.out.println("Max sum for matrix3: " + findMaxSum(matrix3)); // Output should be 4
    }

    public static int findMaxSum(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;

        // Loop through each element in the matrix as starting point
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                maxSum = Math.max(maxSum, calculateMaxSum(matrix, i, j));
            }
        }

        return maxSum;
    }

    private static int calculateMaxSum(int[][] matrix, int row, int col) {
        // initialize maxSum to the current element
        int currentValue = matrix[row][col];
        int maxSum =  0;

        if (row + 1 < matrix.length) {
            // Check the element below
            maxSum = Math.max(maxSum, matrix[row + 1][col] - currentValue + calculateMaxSum(matrix, row + 1, col));
        }

        if (col + 1 < matrix[row].length) {
            // Check the element to the right
            maxSum = Math.max(maxSum, matrix[row][col + 1] - currentValue + calculateMaxSum(matrix, row, col + 1));
        }

        if (row + 1 < matrix.length && col + 1 < matrix[row].length) {
            // Check the diagonally right element
            maxSum = Math.max(maxSum, matrix[row + 1][col + 1] - currentValue + calculateMaxSum(matrix, row + 1, col + 1));
        }

        return maxSum;
    }
}
