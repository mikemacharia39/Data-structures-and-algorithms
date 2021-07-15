package leetTests.arrayandstrings;

import java.util.Arrays;

/**
 * Maximum Sub array
 * Given an integer array nums, find the contiguous sub array
 * (containing at least one number) which has the largest sum and return its sum.
 *
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 *
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 */

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {

        int maxVal = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }

            if (sum > maxVal) {
                maxVal = sum;
            }
        }

        return maxVal;
    }

    public static void main(String[] args) {
        MaximumSubArray subArray = new MaximumSubArray();

        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(Arrays.toString(array));

        System.out.println("Max Val: " + subArray.maxSubArray(array));
        System.out.println("Answer : " + 6);
    }
}
