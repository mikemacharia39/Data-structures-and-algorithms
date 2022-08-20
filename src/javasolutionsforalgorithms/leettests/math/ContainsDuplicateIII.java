package javasolutionsforalgorithms.leettests.math;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate-iii/">...</a>
 *
 * Given an integer array nums and two integers k and t,
 * return true if there are two distinct indices i and j in the array such that abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 *
 * Example 3:
 *
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 */
public class ContainsDuplicateIII {

    /**
     * Not the best solution Time Limit Exceeded -> <a href="https://leetcode.com/submissions/detail/755509850/testcase/">...</a>
     * @param nums nums
     * @param k
     * @param t
     * @return true|false
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if ((nums == null || nums.length == 0) && k > 0 && t > 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                long numDiff = Math.subtractExact(Long.valueOf(nums[i]),Long.valueOf(nums[j])); // so that the result does not overflow
                int indexDiff = Math.abs(i - j);

                if (Math.abs(numDiff) <= t && indexDiff <= k) {
                    return true;
                }
            }
        }

        return false;
    }
}
