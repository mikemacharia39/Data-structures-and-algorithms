package leetTests.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
 *
 * Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
 *
 * A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: 2
 *
 * Example 3:
 * Input: nums = [1,1,1,1]
 * Output: 0
 */
public class LongestHarmoniousSubsequence {

    /**
     *  We shall use a hashmap to store the values against their repetitions
     *  and loop through the keys determining if the current + 1 exist, if so
     *  increase the subsequence
     *
     *  time complexity: 0 (2 * (n))
     *  space complexity: 0 (n) because of the hashmap
     */
    public int findLHS1(int[] nums) {

        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (counts.containsKey(num)) {
                counts.put(num, counts.get(num)+1);
            } else {
                counts.put(num, 1);
            }
        }


        int result = 0;
        for (int val : counts.keySet()) {
            if (counts.containsKey(val+1)) {
                result = Math.max(result, counts.get(val) + counts.get(val+1));
            }
        }

        return result;
    }

    /**
     * In this solution we shall sort the array then find the difference between the
     * current and next vals, if greater shift pointer to the right if lesser shift pointer to
     * the left
     *
     * time complexity: 0 (n) we travesed through the element n times
     * space complexity 0 (1) we did not introduce any new space
     *
     */
    public int findLHS(int[] nums) {

        int left = 0, right = 1, result = 0, numsLength = nums.length;

        Arrays.sort(nums);

        while (right < numsLength) {
            int diff = nums[right] - nums[left];

            // the difference between the window + 1
            if (diff == 1) {
                result = Math.max(result, right - left + 1);
            }

            // shift pointer right
            if (diff <= 1) {
                right++;
            } // shift pointer left
            else {
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LongestHarmoniousSubsequence harmoniousSubsequence = new LongestHarmoniousSubsequence();

        int[] nums = {1,3,2,2,5,2,3,7};
        
        Logger.getLogger(LongestHarmoniousSubsequence.class.getName())
                .log(Level.INFO, "Harmonious subsequence of {0}", Arrays.toString(nums) + " = " +
                        harmoniousSubsequence.findLHS(nums));

        int[] nums1 = {1,2,3,4};
        Logger.getLogger(LongestHarmoniousSubsequence.class.getName())
                .log(Level.INFO, "Harmonious subsequence of {0}", Arrays.toString(nums1) + " = " +
                        harmoniousSubsequence.findLHS(nums1));
    }
}
