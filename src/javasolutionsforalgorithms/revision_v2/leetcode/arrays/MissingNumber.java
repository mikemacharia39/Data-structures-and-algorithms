package javasolutionsforalgorithms.revision_v2.leetcode.arrays;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 *
 * Example 1:
 *
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation:
 * n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 *
 *
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation:
 * n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {

        // it is possible to know the sum of numbers in a sequence if all are present using
        // the formula (n*(n + 1))/2

        int n = nums.length;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        int expectedSum = (n * (n + 1))/2;

        return expectedSum - actualSum;
    }
}
