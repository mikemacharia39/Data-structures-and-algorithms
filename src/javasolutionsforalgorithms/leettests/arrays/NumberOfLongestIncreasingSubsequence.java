package javasolutionsforalgorithms.leettests.arrays;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 *
 * Given an integer array nums, return the number of the longest increasing subsequences.
 * Notice that the sequence has to be strictly increasing
 *
 * Example 1:
 * Input: nums = [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
 *
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of the longest continuous increasing subsequence is 1,
 * and there are 5 subsequences' length is 1, so output 5.
 *
 */
public class NumberOfLongestIncreasingSubsequence {

    public int numberOfLIS(int[] nums) {

        if (nums.length <= 1) {
            return nums.length;
        }

        int[] dp = new int[nums.length];
        int[] counter = new int[nums.length];
        int numLen = nums.length;

        Arrays.fill(dp, 1);
        Arrays.fill(counter, 1);

        int max = 1;

        for (int j = 1; j < numLen; j++) {
            for (int i = 0; i < j; i++) {

                if (nums[j] > nums[i]) {             // similar to the longest increasing subsequence
                    if (dp[i] + 1 > dp[j]) {
                        dp[j] = dp[i] + 1;
                        counter[j] = counter[i];
                    } else if (dp[i] + 1 == dp[j]) { // cater for similarities
                        counter[j] += counter[i];
                    }
                }
            }

            max = Math.max(dp[j], max);
        }

        int count = 0;
        for (int i = 0; i < numLen; i++) {
            if (dp[i] == max) {
                count += counter[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOfLongestIncreasingSubsequence numberOfLIS = new NumberOfLongestIncreasingSubsequence();

        int[] nums = {1,3,5,4,7};

        Logger.getLogger("NumberOfLongestIncreasingSubsequence").
                log(Level.INFO, "Number of Longest increasing subsequence of {0}",
                        Arrays.toString(nums) + " is " + numberOfLIS.numberOfLIS(nums));

        int[] nums2 = {2,2,2,2,2};

        Logger.getLogger("NumberOfLongestIncreasingSubsequence").
                log(Level.INFO, "Number of Longest increasing subsequence of {0}",
                        Arrays.toString(nums2) + " is " + numberOfLIS.numberOfLIS(nums2));
    }
}
