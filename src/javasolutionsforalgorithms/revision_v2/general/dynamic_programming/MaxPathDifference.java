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
public class MaxPathDifference {

    public static int findMaxCumulativeDifference(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // DP table to store the maximum cumulative sums
        int[][] dp = new int[rows][cols];

        // Traverse the matrix from bottom-right to top-left
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                // Initialize the maximum cumulative sum for the current cell
                dp[i][j] = 0;

                // Check right neighbor
                if (j + 1 < cols) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][j + 1] + (matrix[i][j + 1] - matrix[i][j]));
                }

                // Check bottom neighbor
                if (i + 1 < rows) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i + 1][j] + (matrix[i + 1][j] - matrix[i][j]));
                }

                // Check diagonal-right neighbor
                if (i + 1 < rows && j + 1 < cols) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i + 1][j + 1] + (matrix[i + 1][j + 1] - matrix[i][j]));
                }
            }
        }

        // Find the maximum value in the DP table
        int maxDifference = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxDifference = Math.max(maxDifference, dp[i][j]);
            }
        }

        return maxDifference;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {7, 4, 5},
                {8, 2, 1}
        };
        System.out.println(findMaxCumulativeDifference(matrix1)); // Output: -1

        int[][] matrix2 = {
                {7, 2, 5},
                {6, 15, 6},
                {6, 9, 3},
                {2, 8, 16}
        };
        System.out.println(findMaxCumulativeDifference(matrix2)); // Output: 14
    }
}
