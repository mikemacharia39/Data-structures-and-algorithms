package javasolutionsforalgorithms.leettests.arrays;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate-iii/">...</a>
 *
 * You are given an integer array nums and two integers indexDiff and valueDiff.
 *
 * Find a pair of indices (i, j) such that:
 *
 * i != j,
 * abs(i - j) <= indexDiff.
 * abs(nums[i] - nums[j]) <= valueDiff, and
 * Return true if such pair exists or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
 * Output: true
 * Explanation: We can choose (i, j) = (0, 3).
 * We satisfy the three conditions:
 * i != j --> 0 != 3
 * abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
 * abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0
 */
public class ContainsDuplicateIII {

    /**
     * The idea is to create a window and only loop through values lesser than the window
     * and ensure the inner loop does not exceed array size
     *
     * Then within the block check if -> abs(nums[i] - nums[j]) <= valueDiff
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;

        int window ;
        for (int i = 0; i < n; i++) {
            window = i + k;
            for (int j = i + 1; j <= window ; j++) {
                if(j == n){
                    break;
                }
                if (Math.abs(nums[i] - nums[j]) <= t){
                    return true;
                }
            }

        }
        return false;
    }


    /**
     * Not a good solution Time Limit Exceeded
     */
    public boolean containsNearbyAlmostDuplicateSln2(int[] nums, int k, int t) {

        if ((nums == null || nums.length == 0) && k > 0 && t > 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                long numDiff = Math.subtractExact((long) nums[i],nums[j]);
                int indexDiff = Math.abs(i - j);

                if (Math.abs(numDiff) <= t && indexDiff <= k) {
                    return true;
                }
            }
        }

        return false;
    }
}
