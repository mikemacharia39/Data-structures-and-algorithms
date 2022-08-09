package hackerrank.arrays;

import java.util.List;

/**
 * Given an array of integers and a target value, determine the number of pairs of array elements that have a
 * difference equal to the target value.
 *
 * Example 1:
 * k = 1
 * arr = [1,2,3,4]
 * ans = 3
 * There are three values that differ by : 2-1 , 3-2, and 4-3. Return 3.
 *
 * Function Description
 *
 * Complete the pairs function below.
 *
 * pairs has the following parameter(s):
 *
 * int k: an integer, the target difference
 * int arr[n]: an array of integers
 * Returns
 *
 * int: the number of pairs that satisfy the criterion
 *
 * Sample Input
 *
 * k =2
 * arr = [1, 5, 3, 4, 2]
 *
 * Sample Output
 *
 * 3
 * Explanation
 *
 * There are 3 pairs of integers in the set with a difference of 2: [5,3], [4,2] and [3,1]. .
 */
public class PairsByDifference {
    public int pairs(int k, List<Integer> arr) {
        int count = 0;
        for (int num : arr) {
            if (arr.contains(Math.abs(num + k))) {
                count++;
            }
        }
        return count;
    }
}
