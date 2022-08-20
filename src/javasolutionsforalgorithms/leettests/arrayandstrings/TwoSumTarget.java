package javasolutionsforalgorithms.leettests.arrayandstrings;

import java.util.Arrays;
import java.util.HashMap;


/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add
 * up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice
 * You can return the answer in any order.
 *
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSumTarget {

    /**
     * Time complexity: O(n)
     * Space complexity: 0(n)
     * @param nums array
     * @param target sum
     * @return ans
     */
    public int[] twoSum(int[] nums, int target) {

        int numsSize = nums.length;
        int[] output = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numsSize; i++) {
            int rem = target - nums[i];

            if (map.containsKey(rem)) {
                output[0] = i;
                output[1] = map.get(rem);
                return output;
            }
            map.put(nums[i], i);

        }

        return output;
    }


    /**
     * Time complexity: O(n^2)
     * Space complexity: 0(1)
     * @param nums array
     * @param target sum
     * @return ans
     */
    public int[] twoSum1(int[] nums, int target) {

        int numsSize = nums.length;
        int[] output = new int[2];

        for (int i = 0; i < numsSize; i++) {
            for (int j = i+1; j < numsSize; j++) {
                if ((target - nums[i]) == nums[j]) {
                    output[0] = i;
                    output[1] = j;
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {

        //int[] nums = {2,7,11,15}; int target = 9;
        // Output: [0,1], because nums[0] + nums[1] == 9, we return [0, 1].

        //int[] nums = {3,2,4}; int target = 6;
        // Output: [1,2]

        int[] nums = {8,3,0,1,3,9}; int target = 6;

        TwoSumTarget sumTarget = new TwoSumTarget();

        System.out.println(Arrays.toString(sumTarget.twoSum(nums, target)));
    }
}
