package javasolutionsforalgorithms.hackerrank.arrays;

import java.util.List;

/**
 * Watson gives Sherlock an array of integers. His challenge is to find an element of the
 * array such that the sum of all elements to the left is equal to the sum of all elements to the right.
 *
 * Example
 * arr = [5,6,8,11]
 *
 * 8 is between two subarrays that sum to .
 *
 * arr = 1
 *
 * The answer is [1] since left and right sum to 0.
 *
 * You will be given arrays of integers and must determine whether there is an element that meets the criterion.
 * If there is, return YES. Otherwise, return NO.
 *
 * Function Description
 *
 * Complete the balancedSums function in the editor below.
 *
 * balancedSums has the following parameter(s):
 *
 * int arr[n]: an array of integers
 * Returns
 *
 * string: either YES or NO
 *
 *
 * Sample Input 1
 *
 * Example 1:
 * [1 1 4 1 1] = YES
 *
 * Example 2:
 * [2 0 0 0] = YES
 *
 * Example 3:
 * [0 0 2 0] = YES
 */
public class SherlockAndArray {
    public static String balancedSums(List<Integer> arr) {
        int x = 0;
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }

        for (int y : arr) {
            if (2 * x == sum - y) {
                return "YES";
            }
            x = x + y;
        }
        return "NO";
    }
}
