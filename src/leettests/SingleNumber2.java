package leettests;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
 *
 * Example 1:
 *
 * Input: nums = [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 */
public class SingleNumber2 {

    public static void main(String[] args) {
        SingleNumber2 singleNumber2 = new SingleNumber2();

        int[] nums = {0,1,0,1,0,1,99};
        System.out.println(singleNumber2.singleNumber(nums));
    }

    /**
     * This function sets a count to the numbers with a similar value
     * The checking the number that meets the condition
     * @param nums array of integers
     * @return integer
     */
    public int singleNumber(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return 0;
    }
}
