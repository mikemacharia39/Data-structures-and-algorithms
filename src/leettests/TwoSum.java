package leettests;

import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
public class TwoSum {

    /**
     * Time complexity O(n)
     * @param nums input
     * @param target target
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
     * Time complexity O(n^2)
     * @param nums input
     * @param target target
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

        TwoSum twoSum = new TwoSum();
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] vals = twoSum.twoSum(nums, target);

        System.out.println();
    }
}
