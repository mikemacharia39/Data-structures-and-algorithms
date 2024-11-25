package javasolutionsforalgorithms.revision_v2.general.dynamic_programming;

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
                {7, 4, 5},
                {6, 3, 7}
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
        int maxSum = 0;
        int currentValue = matrix[row][col];

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
