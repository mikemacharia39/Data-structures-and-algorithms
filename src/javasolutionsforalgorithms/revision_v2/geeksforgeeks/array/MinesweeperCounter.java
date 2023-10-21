package javasolutionsforalgorithms.revision_v2.geeksforgeeks.array;

import java.util.Arrays;

/**
 * Record the number of mines in the adjacent cells of a matrix
 * <p>
 * input =
 * {
 * {"*", "", "", "*", "", "", ""},
 * {"*", "", "", "", "*", "", ""},
 * {"", "", "*", "", "", "", ""}
 * }
 * <p>
 * output =
 * {
 * {"*", "2", "1", "*", "2", "1", "0"},
 * {"*", "3", "2", "3", "*", "1", "0"},
 * {"1", "2", "*", "2", "1", "1", "0"}
 * }
 */
public class MinesweeperCounter {

    int[][] sides = {
            {-1, 0}, // left
            {1, 0}, // right
            {0, -1}, // top
            {0, 1}, // bottom
            {-1, -1}, // top left
            {-1, 1}, // top right
            {1, -1}, // bottom left
            {1, 1} // bottom right
    };

    public String[][] minesweeperCounter(String[][] minesweeper) {
        int rows = minesweeper.length;
        int cols = minesweeper[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (minesweeper[i][j].equals("*")) {
                    continue;
                }

                int count = countMines(minesweeper, rows, cols, i, j);
                minesweeper[i][j] = String.valueOf(count);
            }
        }
        return minesweeper;
    }

    public int countMines(String[][] minesweeper, int rows, int cols, int i, int j) {
        int count = 0;

        for (int[] side : sides) {
            int x = i + side[0];
            int y = j + side[1];
            if (x >= 0 && x < rows && y >= 0 && y < cols && minesweeper[x][y].equals("*")) {
                count++;
            }
        }
        return count;
    }

    public int countMines1(String[][] minesweeper, int rows, int cols, int i, int j) {
        int count = 0;
        // left
        if (i - 1 >= 0 && minesweeper[i-1][j].equals("*")) {
            count++;
        }
        // right
        if (i + 1 < rows && minesweeper[i+1][j].equals("*")) {
            count++;
        }
        // top
        if (j - 1 >= 0 && minesweeper[i][j-1].equals("*")) {
            count++;
        }
        // bottom
        if (j + 1 < cols && minesweeper[i][j+1].equals("*")) {
            count++;
        }
        // top left
        if (i - 1 >= 0 && j - 1 >= 0 && minesweeper[i-1][j-1].equals("*")) {
            count++;
        }
        // top right
        if (i - 1 >= 0 && j + 1 < cols && minesweeper[i-1][j+1].equals("*")) {
            count++;
        }
        // bottom left
        if (i + 1 < rows && j - 1 >= 0 && minesweeper[i+1][j-1].equals("*")) {
            count++;
        }
        // bottom right
        if (i + 1 < rows && j + 1 < cols && minesweeper[i+1][j+1].equals("*")) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        MinesweeperCounter minesweeperCounter = new MinesweeperCounter();

        String[][] input = {
                {"*", "", "", "*", "", "", ""},
                {"*", "", "", "", "*", "", ""},
                {"", "", "*", "", "", "", ""}
        };

        System.out.println(Arrays.deepToString(minesweeperCounter.minesweeperCounter(input)));
    }
}
