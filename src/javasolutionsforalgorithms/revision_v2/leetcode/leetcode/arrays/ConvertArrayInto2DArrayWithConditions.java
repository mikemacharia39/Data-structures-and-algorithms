package javasolutionsforalgorithms.revision_v2.leetcode.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConvertArrayInto2DArrayWithConditions {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param nums
     * @return
     */
    public List<List<Integer>> findMatrix(int[] nums) {

        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

        int totalFreq = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            totalFreq++;
        }

        List<List<Integer>> list = new ArrayList<>();

        while (totalFreq > 0) {
            List<Integer> innerList = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                innerList.add(entry.getKey());

                map.put(entry.getKey(), entry.getValue() - 1);


                if (map.get(entry.getKey()) == 0) {
                    map.remove(entry.getKey());
                }


                totalFreq--;
            }


            list.add(innerList);
        }

        return list;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param nums
     * @return
     */
    public List<List<Integer>> findMatrix1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            map.put(i, 1 + map.getOrDefault(i, 0));
            set.add(i);
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (!map.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            for (int key : set) {
                if (map.containsKey(key)) {
                    int cnt = map.get(key);
                    row.add(key);
                    if (cnt == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, --cnt);
                    }
                }
            }
            ans.add(row);
        }

        return ans;
    }
}
