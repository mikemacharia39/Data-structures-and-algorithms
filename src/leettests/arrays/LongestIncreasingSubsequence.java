package leettests.arrays;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no
 * elements without changing the order of the remaining elements.
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 *
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 */
public class LongestIncreasingSubsequence {
    /**
     * This is best explained here:
     * https://www.youtube.com/watch?v=fV-TF4OvZpk&ab_channel=BackToBackSWE
     *
     * We shall use dynamic programming
     * We start by initializing an empty array
     * with it's length similar to our original array length and
     * populating our array with 1 for default values
     * the having 2 pointers
     * 1 checking the start and the other start + 1
     * We then compare the element, if left is lesser that right
     * update the our array + 1, otherwise
     *
     */
    public int lengthOfLIS(int[] nums) {

        // if the length of the array is lesser that or equal to 1, return the
        // arr length
        if (nums.length <= 1) {
            return nums.length;
        }

        int[] counter = new int[nums.length];

        Arrays.fill(counter, 1);

        for (int j = 1; j < nums.length; j++) {
            for (int i = 0; i < j; i++) {
                // check if the next element is greater than the previous
                if (nums[j] > nums[i]) {
                    // update the value of our counter by 1 whenever
                    // the new counter is greater than the previous
                    if (counter[i] + 1 > counter[j]) {
                        counter[j] = counter[i] + 1;
                    }
                }
            }
        }

        int maxVal = 0;
        for (int k : counter) {
            maxVal = Math.max(maxVal, k);
        }

        return maxVal;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence increasingSubsequence = new LongestIncreasingSubsequence();

        int[] array = {10,9,2,5,3,7,101,18};
        Logger.getLogger(LongestIncreasingSubsequence.class.getName())
                .log(Level.INFO, "Longest inc subsequence of {0}",
                        Arrays.toString(array) + " is " +
                                increasingSubsequence.lengthOfLIS(array));
    }
}
