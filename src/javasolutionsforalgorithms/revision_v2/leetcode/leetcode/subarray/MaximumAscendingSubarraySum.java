package javasolutionsforalgorithms.revision_v2.leetcode.leetcode.subarray;

public class MaximumAscendingSubarraySum {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int currSum = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                currSum += nums[i];
            } else {
                max = Math.max(max, currSum);
                currSum = nums[i];
            }
        }

        return Math.max(currSum, max);
    }
}
