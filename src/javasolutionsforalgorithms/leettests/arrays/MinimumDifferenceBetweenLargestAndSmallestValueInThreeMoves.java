package javasolutionsforalgorithms.leettests.arrays;


import java.util.Arrays;

/**
 * You are given an integer array nums.
 * In one move, you can choose one element of nums and change it to any value.
 * Return the minimum difference between the largest and smallest value of nums after performing at most three moves.
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
        int end = nums.length - 3 - 1; // crucial
        while (start < n && end < n) {
            min = Math.min(min, nums[end] - nums[start]);
            start++;
            end++;
        }

        return min;
    }
}
