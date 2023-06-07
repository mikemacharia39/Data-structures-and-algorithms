package javasolutionsforalgorithms.revision_v2.leetcode.google.arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    /**
     * Using streams to sort, limit by k, convert  to list and then return an array
     */
    public int[] topKFrequent_1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> ans = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .limit(k)
                .map(a -> a.getKey())
                .toList();

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = ans.get(i);
        }

        return arr;
    }

    /**
     * Using streams, but then immediately after sorting, limit and convert map to
     * int and convert to an array
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .limit(k)
                .mapToInt(a -> a.getKey())
                .toArray();
    }
}
