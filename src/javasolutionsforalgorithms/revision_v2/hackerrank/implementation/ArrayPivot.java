package javasolutionsforalgorithms.revision_v2.hackerrank.implementation;

/**
 * Pivot Index
 * <a href="https://leetcode.com/problems/find-pivot-index/">...</a>
 *
 * Given an array of integers nums, calculate the pivot index of this array.
 *
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum
 * of all the numbers strictly to the index's right.
 *
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
 * This also applies to the right edge of the array.
 *
 * Return the leftmost pivot index. If no such index exists, return -1.
 */
public class ArrayPivot {

    public static int pivotIndex(int[] nums) {
        int leftSum = 0;
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == (totalSum - leftSum - nums[i])) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    /**
     * Time complexity: O(n^2)
     * @param nums
     * @return
     */
    public static int pivotIndex1(int[] nums) {
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            int rightSum = sum(nums, i, nums.length);
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    private static int sum(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }
}
