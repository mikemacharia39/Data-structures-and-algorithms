package javasolutionsforalgorithms.neetcode.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 *
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        return Arrays.stream(nums).distinct().count() != nums.length;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(value -> set.add(value));
        if (set.size() != nums.length) {
            return true;
        }
        return false;
    }
}
