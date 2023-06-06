package javasolutionsforalgorithms.revision_v2.leetcode.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
