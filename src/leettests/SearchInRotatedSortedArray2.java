package leettests;

/**
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 *
 * Before being passed to your function, nums is rotated at an unknown pivot
 * index k (0 <= k < nums.length) such that the resulting
 * array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
 *
 * Given the array nums after the rotation and an integer target, return true if target is in nums,
 * or false if it is not in nums.
 */
public class SearchInRotatedSortedArray2 {
    public static void main(String[] args) {

//        int[] nums = {1};
//        int val = 1;
//        int[] nums = {1,0,3};
//        int val = 3;
        int[] nums = {2,5,6,0,0,1,2};
        int val = 0;

        SearchInRotatedSortedArray2 search = new SearchInRotatedSortedArray2();

        System.out.println(search.search(nums, val));

    }
    public boolean search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[high]) { // failure means nums[mid] >= nums[high]
                if (nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            } else if (nums[mid] > nums[low]) { // failure means nums[mid] <= nums[low]
                if (nums[low] <= target && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else if (nums[mid] == nums[low]) {
                low++;
            } else if (nums[mid] == nums[high]) {
                high--;
            }
        }
        return false;
    }
}
