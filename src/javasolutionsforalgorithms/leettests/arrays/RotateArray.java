package javasolutionsforalgorithms.leettests.arrays;


/**
 * <a href="https://leetcode.com/problems/rotate-array/">...</a>
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 *
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 *
 * Follow up:
 *
 * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class RotateArray {


    //==================== SOLUTION 1 ======================

    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k %= n;

        // reverse all elements of the array
        reverse(nums, 0, n-1);

        // reverse all elements from 0 to k
        reverse(nums, 0, k-1);

        // reverse all elements from k to n - 1
        reverse(nums, k, n-1);
    }

    public void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    //==================== SOLUTION 2 ======================

    /**
     * shift the array elements such that at position (i+k)%n = i
     *
     * @param nums nums
     * @param k shift
     */
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];

        // shift the elements in the array by k such that
        // items in the original ith position are assigned items at (i+k)%n
        for (int i = 0; i < n; i++) {
            temp[(i+k)%n] = nums[i];
        }
        for (int j = 0; j < n; j++) {
            nums[j] = temp[j];
        }
//        System.arraycopy(temp, 0, nums, 0, n);
    }

    //==================== SOLUTION 3 ======================

    /**
     * Naive approach. Rotation K times while shifting elements of the array to the right
     * Time complexity O(k*m) where K is the number
     */
    public void rotate2(int[] nums, int k) {

        k %= nums.length;
        for (int i = 0; i < k; i++) {
            shift(nums);
        }
    }

    public void shift(int[] nums) {
        int start = nums[nums.length-1];
        for (int i = nums.length - 1; i >= 1; i--) {
            nums[i] = nums[i-1];
        }
        nums[0] = start;
    }
}
