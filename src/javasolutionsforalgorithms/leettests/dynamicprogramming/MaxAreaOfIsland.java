package javasolutionsforalgorithms.leettests.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/max-area-of-island/">...</a>
 *
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 * Example
 *[
 *     [1,1,0,0,0],
 *     [1,1,0,0,0],
 *     [0,0,0,1,1],
 *     [0,0,0,1,1]
 *]
 * Max area of island is 4
 */
public class MaxAreaOfIsland {

    // https://www.youtube.com/watch?v=W8VuDt0eb5c&ab_channel=KevinNaughtonJr.
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfsFilling(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    public int dfsFilling(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1) {
            return 0;
        }
        if (grid[row][col] == 0) {
            return 0;
        }
        int count = 1; // having entered the loop

        // mark the areas as visited
        grid[row][col] = 0;

        count += dfsFilling(grid, row+1, col);
        count += dfsFilling(grid, row-1, col);
        count += dfsFilling(grid, row, col+1);
        count += dfsFilling(grid, row, col-1);

        return count;
    }
}
