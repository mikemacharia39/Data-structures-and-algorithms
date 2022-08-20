package javasolutionsforalgorithms.leettests.arrays;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Given an array of integers nums, sort the array in ascending order.
 *
 * Example 1:
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 */
public class SortArray {

    /**
     * Brute force
     * time complexity = 0 (n^2)
     * space complexity 0(1)
     * @param nums nums
     * @return sorted nums
     */
    public int[] sortArray1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1]) {
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;

                i = -1;
            }
        }

        return nums;
    }

    public int[] sortArray(int[] nums) {
        mergesort(nums, 0, nums.length-1);
        return nums;
    }

    public void mergesort(int[] nums, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            mergesort(nums, start, mid);
            mergesort(nums, mid+1, end);
            merge(nums, start, mid, end);
        }
    }

    public void merge(int[] nums, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int[] temp = new int[end - start + 1];
        int k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        } //copy remaining elements
        while (j <= end) {
            temp[k++] = nums[j++];
        } //copy remaining elements
        for (int pointer = start; pointer <= end; pointer++) {
            nums[pointer] = temp[pointer - start];
        }
    }



    public static void main(String[] args) {
        SortArray sortArray = new SortArray();

        int[] nums = {5,2,3,1};
        int[] nums2 = {8,9,10,1,99,1,3,4,45,23,6,7,8,11,23,78,90,34,67,56,57,8};

        Logger.getLogger(SortArray.class.getName())
                .log(Level.INFO, "Sorting {0}", Arrays.toString(nums) + " = "
                        + Arrays.toString(sortArray.sortArray(nums)));

        Logger.getLogger(SortArray.class.getName())
                .log(Level.INFO, "Sorting {0}", Arrays.toString(nums2) + " = "
                        + Arrays.toString(sortArray.sortArray(nums2)));

    }
}
