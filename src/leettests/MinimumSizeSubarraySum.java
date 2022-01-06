package leettests;

/**
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is
 * greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {

        MinimumSizeSubarraySum subarraySum = new MinimumSizeSubarraySum();

        int target = 7;
        int[] nums = {2,3,1,2,4,3};

        System.out.println(subarraySum.minSubArrayLen(target, nums));

    }

    public int minSubArrayLen(int target, int[] nums) {
        /**
         * Time complexity: O(n). Single iteration of O(n).
         *  Each element can be visited atmost twice, once by the left pointer.
         * Space complexity: O(1)O(1) extra space.
         *  Only constant space required for sum, ans and i and j.
         */

        int i = 0, j = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (i < nums.length) {
            sum += nums[i++];
            while (sum >= target) {
                minLen = Math.min(minLen, i - j);
                sum -= nums[j++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }

    public int minSubArrayLenSln2(int target, int[] nums) {

        // contiguous meaning following each other
        // Require 2 pointers
        // pointer will start at i = 0 j = i

        /**
         * Time complexity is O(n^2) because per we have to visit every item
         *  to find all values
         * Space complexity: O(1) extra space.
         *  Only constant space required for sum, ans and i and j.
         */

        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    minLen = Math.min(minLen, j - i + 1);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }
}
