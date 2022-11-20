package javasolutionsforalgorithms.leettests.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/island-perimeter/">...</a>
 *
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 *
 * Example 1:
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 *
 * Example 2:
 *
 * Input: grid = [[1]]
 * Output: 4
 *
 * Example 3:
 *
 * Input: grid = [[1,0]]
 * Output: 4
 *
 */
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {

        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;
        int sideUnoccupied = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) sideUnoccupied++; // UP
                    if (j == 0 || grid[i][j - 1] == 0) sideUnoccupied++; // LEFT
                    if (i == rows -1 || grid[i + 1][j] == 0) sideUnoccupied++; // DOWN
                    if (j == cols -1 || grid[i][j + 1] == 0) sideUnoccupied++; // RIGHT
                }
            }
        }

        return sideUnoccupied;
    }
}
