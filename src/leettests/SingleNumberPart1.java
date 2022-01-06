package leettests;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 1
 */

public class SingleNumberPart1 {

    public static void main(String[] args) {
        SingleNumberPart1 singleNumberPart1 = new SingleNumberPart1();
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumberPart1.singleNumber(nums));
    }

    public int singleNumberSln2(int[] nums) {
        List<Integer> slist = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!slist.contains(nums[i])) {
                slist.add(nums[i]);
            } else {
                slist.remove(slist.indexOf(nums[i]));
            }
        }

        return slist.get(0);
    }

    public int singleNumber(int[] nums) {
        // This requires knowledge in XOR
        // Basically
        // TRUE XOR TRUE = FALSE
        // FALSE XOR FALSE = FALSE
        // FALSE XOR TRUE = TRUE
        // TRUE XOR FALSE = TRUE
        // 4,1,2,1,2
        // 0 ^ 4 = 4
        // 4 ^ 1 = 5
        // 5 ^ 2 = 7
        // 7 ^ 1 = 6
        // 6 ^ 2 = 4

        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x = x ^ nums[i];
        }
        return x;
    }
}
