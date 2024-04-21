package javasolutionsforalgorithms.revision_v2.leetcode.subarray;

/**
 * You are given an integer array nums consisting of n elements, and an integer k.
 *
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
 * Any answer with a calculation error less than 10^5 will be accepted.
 *
 * Example 1:
 *
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 */
public class MaximumAverageSubArray1 {

    public double findMaxAverage1(int[] nums, int k) {
        double max = -100000;
        for (int i = 0; i < nums.length-k + 1; i++) {
            double sum = 0;
            for (int j = i; j < i + k; j++) {
                if (j < nums.length) {
                    sum += nums[j];
                }
            }
            double division = sum / k;
            max = Math.max(division, max);
        }
        return max;
    }
}
