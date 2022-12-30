package javasolutionsforalgorithms.leettests.arrays;


import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/">...</a>
 *
 * You are given an integer array nums.
 * In one move, you can choose one element of nums and change it to any value.
 * Return the minimum difference between the largest and smallest value of nums after performing at most three moves.
 *
 * Example:
 *
 * Input: nums = [1,5,0,10,14]
 * Output: 1
 * Explanation: We can make at most 3 moves.
 * In the first move, change 5 to 0. nums becomes [1,0,0,10,14].
 * In the second move, change 10 to 0. nums becomes [1,0,0,0,14].
 * In the third move, change 14 to 1. nums becomes [1,0,0,0,1].
 * After performing 3 moves, the difference between the minimum and maximum is 1 - 0 = 0.
 * It can be shown that there is no way to make the difference 0 in 3 moves.
 */
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public int minDifference(int[] nums) {
        // by default an array whose size <= 4 should have min difference of 0
        if (nums.length <= 4) {
            return 0;
        }

        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int start = 0;
        int end = nums.length - 3 - 1; // crucial and caters for number of moves
        while (start < n && end < n) {
            min = Math.min(min, nums[end] - nums[start]);
            start++;
            end++;
        }

        return min;
    }
}
