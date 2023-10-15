package javasolutionsforalgorithms.revision_v2.google.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">...</a>
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * Your solution must use only constant extra space.
 * Example 1:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 */
public class TwoSumIIInputArrayIsSorted {
    /**
     * Binary search
     * ----
     * Using 2 pointers while shifting the position of the pointers
     * based on whether the summation of left and right exceeds the target
     *
     */
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n - 1;

        while (numbers[right] + numbers[left] != target) {
            if ((numbers[right] + numbers[left]) > target) {
                right--;
            } else if ((numbers[right] + numbers[left]) < target) {
                left++;
            }
        }

        return new int[] {left + 1, right + 1};
    }


    /**
     * HashMap
     * Use a hashmap to store the numbers
     * while referencing whether the numbers already exist in the map
     */
    public int[] twoSum_HashMap(int[] numbers, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        // i < numbers.length + 1 because we need to check if the last value added
        // to the hashmap has is such that target - the number already exists
        for (int i = 0; i <= numbers.length; i++) {

            if (map.containsKey(target - numbers[i])) {
                ans[0] = map.get(target - numbers[i]);
                ans[1] = i+1;

                break;
            }

            map.put(numbers[i], i+1);
        }

        return ans;
    }

    /**
     * Time limit exceeded
     * Bad when duplicates exist, but can work
     */
    public int[] twoSum_List(int[] numbers, int target) {
        int n = numbers.length;
        List<Integer> diffs = new ArrayList<>(n);
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            if (diffs.contains(numbers[i])) {
                ans[0] = diffs.indexOf(numbers[i]) + 1;
                ans[1] = i + 1;
            }
            diffs.add(target - numbers[i]);
        }

        return ans;
    }

}
