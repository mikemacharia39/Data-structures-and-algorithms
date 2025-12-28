package javasolutionsforalgorithms.leettests.arrayandstrings;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the first duplicate value i.e.
 *
 * Example 1:
 * Given integer array {1,2,1,3,5,3}, there are two duplicate values 1 and 3, but 1 occurs first
 */
public class FirstDuplicate {

    public static void main(String[] args) {

        int[] nums = {1,2,1,3,5,3}; // first duplicate is 1

        int firstDuplicate = -1;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                firstDuplicate = num;
                break;
            } else {
                set.add(num);
            }
        }

        System.out.println("First Duplicate is: " + firstDuplicate);
    }
}
