package javasolutionsforalgorithms.leettests.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/sort-array-by-increasing-frequency/">...</a>
 *
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
 * If multiple values have the same frequency, sort them in decreasing order.
 *
 * Return the sorted array.
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,2,2,3]
 * Output: [3,1,1,2,2,2]
 * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
 *
 * Example 2:
 *
 * Input: nums = [2,3,1,3,2]
 * Output: [1,3,3,2,2]
 * Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
 */
public class SortArrayByIncreasingFrequency {

    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] listFreq = new ArrayList[nums.length + 1];

        for(int key : map.keySet()) {
            int freq = map.get(key);
            if (listFreq[freq] == null) {
                listFreq[freq] = new ArrayList<>();
            }
            listFreq[freq].add(key);
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (listFreq[i] != null) {
                List<Integer> currList = listFreq[i];
                for (int val : currList) {
                    for (int j = 0; j < i; j ++) {
                        nums[count] = val;
                        count++;
                    }
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        SortArrayByIncreasingFrequency sortArrayByIncreasingFrequency = new SortArrayByIncreasingFrequency();
        int[] nums = {3,1,1,2,2,2};

        int [] res = sortArrayByIncreasingFrequency.frequencySort(nums);
        System.out.println("Result: " + Arrays.toString(res));
    }
}
