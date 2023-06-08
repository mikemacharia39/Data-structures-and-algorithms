package javasolutionsforalgorithms.revision_v2.leetcode.google.math;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/">...</a>
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of
 * nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {

    /**
     * It first calculates the product of all elements to the left of each
     * element and stores it in the answer array. Then, it calculates the
     * product of all elements to the right of each element and multiplies
     * it with the corresponding left product stored in the answer array.
     * This way, each element in the answer array will contain the product
     * of all elements except itself.
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int leftProduct = 1;
        int i = 0;
        while (i < n) {
            ans[i] = leftProduct;
            leftProduct *= nums[i];
            i++;
        }

        int rightProduct = 1;
        int j = n - 1;
        while (j >= 0) {
            ans[j] *= rightProduct;
            rightProduct *= nums[j];
            j--;
        }

        return ans;
    }
}
