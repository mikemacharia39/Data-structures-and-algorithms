package javasolutionsforalgorithms.revision_v2.leetcode.google.arrays;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class MostFrequentEvenElement {


    public int mostFrequentEven_2(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }

        if (map.isEmpty()) {
            return - 1;
        }

        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .limit(1)
                .map(a -> a.getKey())
                .findFirst()
                .get();
    }
}
