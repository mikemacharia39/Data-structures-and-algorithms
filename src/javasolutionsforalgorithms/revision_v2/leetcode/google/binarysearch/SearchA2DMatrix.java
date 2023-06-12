package javasolutionsforalgorithms.revision_v2.leetcode.google.binarysearch;

/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix/">...</a>
 *
 * You are given an m x n integer matrix matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 *
 * Example 1:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 */
public class SearchA2DMatrix {

    /**
     * The time complexity of the algorithm is O(rows + log(cols)), where "rows" is the number of rows in the matrix
     * and "cols" is the number of columns in the matrix.
     *
     * The first loop iterates through the rows of the matrix, which has a time complexity of O(rows).
     *
     * After finding the appropriate row, the algorithm performs binary search within that row to find the target element.
     * The binary search has a time complexity of O(log(cols)), where "cols" is the number of columns in the matrix.
     *
     * Therefore, the overall time complexity is O(rows + log(cols)).
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int foundRow = -1;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] <= target && matrix[i][cols-1] >= target) {
                foundRow = i;
                break;
            }
        }

        if (foundRow == -1) return false;

        int left = 0;
        int right = cols;

        while (left < right) {
            int mid = left + (right - left)/2;

            if (matrix[foundRow][mid] == target) {
                return true;
            }

            if (matrix[foundRow][mid] > target) {
                right = mid;
            } else if (matrix[foundRow][mid] < target) {
                left = mid + 1;
            }
        }

        return false;
    }

    /**
     * Explanation: We are checking where the target number could be in the matrix.
     * If not found, we return false. If found, we are creating a new array of size n (number of columns)
     * We then do a binary search on the matrix to find the row where the target number could be.
     * Time complexity: O(m + log(n)), where m is the number of rows and n is the number of columns
     * space complexity: O(n), because we are creating a new array of size n (number of columns
     * @param matrix 2D matrix
     * @param target target number to search
     * @return true if found, false otherwise
     */
    public boolean searchMatrix_1(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int foundRow = -1;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] <= target && matrix[i][cols-1] >= target) {
                foundRow = i;
                break;
            }
        }

        if (foundRow == -1) return false;

        int[] numbers = new int[cols];
        for (int j = 0; j < cols; j++) {
            numbers[j] = matrix[foundRow][j];
        }

        if (numbers.length == 1) {
            return numbers[0] == target ? true : false;
        }

        int left = 0;
        int right = numbers.length;

        while (left < right) {
            int mid = left + (right - left)/2;

            if (numbers[mid] == target) {
                return true;
            }

            if (numbers[mid] > target) {
                right = mid;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            }
        }

        return false;
    }

    /**
     * Time complexity: O(m * n) because we are iterating through the matrix, looking for the target
     * Space complexity: O(m * n) because we are creating a new array of size m * n
     * @param matrix 2D matrix
     * @param target target number to search
     * @return true if found, false otherwise
     */
    public boolean searchMatrix__2(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int n = rows * cols;
        int[] numbers = new int[n];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}
