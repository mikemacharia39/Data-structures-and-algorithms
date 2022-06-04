package hackerrank.arrays;

import java.util.Collections;
import java.util.List;

/**
 * The absolute difference is the positive difference between two values a and b,
 * is written |a-b| or |b-a|  and they are equal. If a = 3 and b = 2, |3-2| or |2-3| = 1.
 * Given an array of integers, find the minimum absolute difference between any two elements in the array.
 *
 * Example
 *  [3, -7, 0]
 *
 * Output = 3
 *
 * Function Description
 *
 * Complete the minimumAbsoluteDifference function in the editor below.
 * It should return an integer that represents the minimum absolute difference between any pair of elements.
 *
 * minimumAbsoluteDifference has the following parameter(s):
 *
 * int arr[n]: an array of integers
 */
public class MinimumAbsoluteDifference {

    /**
     * Time complexity O(n log n)
     *
     * @param arr list
     * @return res
     */
    public static int minimumAbsoluteDifference(List<Integer> arr) {

        int min = Integer.MAX_VALUE;
        Collections.sort(arr);

        for (int i = 0; i < arr.size()-1; i++) {
            if (Math.abs(arr.get(i) - arr.get(i+1)) == Math.abs(arr.get(i+1) - arr.get(i))) {
                min = Math.min(Math.abs(arr.get(i) - arr.get(i+1)), min);
            }
        }

        return min;
    }

    /**
     * Takes too long
     * Time complexity O(n^2)
     *
     * @param arr list
     * @return res
     */
    public static int minimumAbsoluteDifference2(List<Integer> arr) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i+1; j < arr.size(); j++) {
                if (Math.abs(arr.get(i) - arr.get(j)) == Math.abs(arr.get(j) - arr.get(i))) {
                    min = Math.min(Math.abs(arr.get(i) - arr.get(j)), min);
                }
            }
        }

        return min;
    }
}
