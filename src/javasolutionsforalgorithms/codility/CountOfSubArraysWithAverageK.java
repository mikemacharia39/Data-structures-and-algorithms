package javasolutionsforalgorithms.codility;

/**
 * <a href="https://www.geeksforgeeks.org/count-of-subarrays-with-average-k/">...</a>
 * <p>
 * Count of subarrays with average K
 * <p>
 * Given an array nums and avg = 2, find the number of subarrays whose sum of elements divided by the number of
 * elements is equals to the average
 * <p>
 * Example 1:
 * <p>
 * [0,4,3,-1]  avg=2
 * e.g. [0,4] and [4,3,-1] = there are 2 contiguous subarray
 * <p>
 * Example 2:
 * <p>
 * Input: arr[ ] = {1, 4, 2, 6, 10}, N = 6, K = 4
 * Output: 3
 * Explanation: The subarrays with an average equal to 4 are {4}, {2, 6}, {4, 2, 6}.
 * <p>
 * Input: arr[ ] = {12, 5, 3, 10, 4, 8, 10, 12, -6, -1}, N = 10, K = 6
 * Output: 4
 */
public class CountOfSubArraysWithAverageK {

    public int countKAverageSubArrays(int[] nums, int avg) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int subLen = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                subLen = j - i + 1;
                if (sum % subLen == 0 && sum / subLen == avg) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountOfSubArraysWithAverageK count = new CountOfSubArraysWithAverageK();
        int[] arr = {0, 4, 3, -1};
        int avg = 2;
        System.out.println(count.countKAverageSubArrays(arr, avg));
    }
}
