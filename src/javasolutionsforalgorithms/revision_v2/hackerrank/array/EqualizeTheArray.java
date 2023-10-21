package javasolutionsforalgorithms.revision_v2.hackerrank.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://www.hackerrank.com/challenges/equality-in-a-array/problem">...</a>
 *
 * Given an array of integers, determine the minimum number of elements to delete to leave only elements of equal value.
 *
 * Example
 * arr = {1,2,2,3}
 *
 * Delete the 2 elements 1 and 3 leaving arr = [2,2].
 * If both twos plus either the 1 or the 3 are deleted, it takes 2 deletions to leave either 3 or 1.
 * The minimum number of deletions is 2.
 *
 * Sample Input
 *
 * STDIN       Function
 * -----       --------
 * 3 3 2 1 3   arr = [3, 3, 2, 1, 3]
 *
 * Sample Output = 2, because we deleted 2,1 and the arr = [3,3,3]
 *
 */
public class EqualizeTheArray {

    public static int equalizeArray(List<Integer> arr) {
        if (arr.size() < 2) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int frequency = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > frequency) {
                frequency = entry.getValue();
            }
        }

        return arr.size() - frequency;
    }
}
