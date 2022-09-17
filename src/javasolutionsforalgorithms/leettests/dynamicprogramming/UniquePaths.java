package javasolutionsforalgorithms.leettests.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/unique-paths/">...</a>
 *
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 *
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the
 * bottom-right corner.
 *
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 *
 * Example 1:
 *
 * Input: m = 3, n = 7
 * Output: 28
 *
 *
 * Example 2:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 *
 *
 */
public class UniquePaths {

    /**
     * Optimizing approach 1 where there exists 0s update with 1s
     * The adding rows agains columns
     */
    public int uniquePaths(int m, int n) {

        // m is rows
        // n is columns
        // populate the first row and the first column with 1
        // then add them against each other

        int[][] table = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 1;
                } else {
                    table[i][j] = table[i-1][j] + table[i][j-1];
                }
            }
        }

        return table[m-1][n-1];
    }

    /**
     * From a naive approach, populate the first row and first column with 1
     * then add row against column
     * Time complexity O(2*n + n^2) => O(n^2)
     *
     *   |1|1|1|1|
     *   ---------
     *   |1|0|0|0|
     *   ---------
     *   |1|0|0|0|
     *
     */
    public int uniquePaths1(int m, int n) {

        // m is rows
        // n is columns
        // populate the first row and the first column with 1
        // then add them against each other

        int[][] table = new int[m][n];

        for (int i = 0; i < m; i++) {
            table[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            table[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                table[i][j] = table[i-1][j] + table[i][j-1];
            }
        }

        return table[m-1][n-1];
    }
}
