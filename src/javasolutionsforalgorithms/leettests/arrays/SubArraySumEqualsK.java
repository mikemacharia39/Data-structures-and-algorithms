package javasolutionsforalgorithms.leettests.arrays;

/**
 * <a href="https://leetcode.com/problems/subarray-sum-equals-k/">...</a>
 *
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 *
 *
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 */
public class SubArraySumEqualsK {


    /**
     * Time complexity 0(n^2)
     * @param nums nums
     * @param k k
     * @return count
     */
    public int subarraySum_2(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
