package javasolutionsforalgorithms.revision_v2.leetcode.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <a href="https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/">...</a>
 *
 * You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:
 *
 * The 2D array should contain only the elements of the array nums.
 * Each row in the 2D array contains distinct integers.
 * The number of rows in the 2D array should be minimal.
 * Return the resulting array. If there are multiple answers, return any of them.
 *
 * Note that the 2D array can have a different number of elements on each row.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,1,2,3,1]
 * Output: [[1,3,4,2],[1,3],[1]]
 * Explanation: We can create a 2D array that contains the following rows:
 * - 1,3,4,2
 * - 1,3
 * - 1
 * All elements of nums were used, and each row of the 2D array contains distinct integers, so it is a valid answer.
 * It can be shown that we cannot have less than 3 rows in a valid array.
 */
public class ConvertArrayInto2DArrayWithConditions {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n): map
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
     * Space complexity: O(n): map + set
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
