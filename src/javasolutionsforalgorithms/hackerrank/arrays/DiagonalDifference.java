package javasolutionsforalgorithms.hackerrank.arrays;

import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-diagonal-difference/problem">...</a>
 *
 * Given a square matrix, calculate the absolute difference between the sums of its diagonals.
 *
 * For example, the square matrix  is shown below:
 *
 * 1 2 3
 * 4 5 6
 * 9 8 9
 * The left-to-right diagonal 1 + 5 + 9 = 15. The right to left diagonal 3 + 5 + 9= 17. Their absolute difference is 2.
 *
 * Function description
 *
 * Complete the  function in the editor below.
 *
 * diagonal Difference takes the following parameter:
 *
 * int arr[n][m]: an array of integers
 * Return
 *
 * int: the absolute diagonal difference
 *
 * Input Format
 *
 *
 * Sample Input
 *
 * 11  2  4
 * 4   5  6
 * 10  8 -12
 *
 * Output = 15
 *
 */
public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {

        int lrsum = 0;
        int rlsum = 0;
        for (int i = 0; i < arr.size(); i++) {
            lrsum += arr.get(i).get(i);
        }

        for (int i = arr.size() -1; i >= 0; i--) {
            rlsum += arr.get(i).get(arr.size()-i-1);
        }

        return Math.abs(rlsum - lrsum);
    }
}
