package leettests.arrays;

/**
 * <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">...</a>
 * <p>
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of
 * each number sorted in non-decreasing order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * <p>
 * Example 2:
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * <p>
 * **Follow up**: Squaring each element and sorting the new array is very trivial,
 * could you find an O(n) solution using a different approach?
 */
public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int beginPositive = 0;
        int endNegative = 0;
        int[] ans = new int[n];

        // find where the positive numbers start
        while (beginPositive < n && nums[beginPositive] < 0) {
            beginPositive++;
        }

        // Where negative numbers end
        endNegative = beginPositive - 1;
        int k = 0;
        while (endNegative >= 0 && beginPositive < n) {
            if (nums[endNegative] * nums[endNegative] > nums[beginPositive] * nums[beginPositive]) {
            // if (Math.abs(nums[endNegative]) > Math.abs(nums[beginPositive])) {  // you can chose to compare this way too
                ans[k] = nums[beginPositive] * nums[beginPositive];
                beginPositive++;
            } else {
                ans[k] = nums[endNegative] * nums[endNegative];
                endNegative--;
            }
            k++;
        }

        while (beginPositive < n) {
            ans[k] = nums[beginPositive] * nums[beginPositive];
            beginPositive++;
            k++;
        }

        while (endNegative >= 0) {
            ans[k] = nums[endNegative] * nums[endNegative];
            endNegative--;
            k++;
        }
        return ans;
    }
}
