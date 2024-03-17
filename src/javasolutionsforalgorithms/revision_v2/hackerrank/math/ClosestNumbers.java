package javasolutionsforalgorithms.revision_v2.hackerrank.math;

import java.util.*;

/**
 * <a href="https://www.hackerrank.com/challenges/closest-numbers/problem">...</a>
 * Sorting is useful as the first step in many different tasks.
 * The most common task is to make finding things easier, but there are other uses as well.
 * In this case, it will make it easier to determine which pair or pairs of elements have the smallest absolute
 * difference between them.
 *
 * Example 1:
 * arr = [-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854]
 *
 * answer = [-20, 30]
 *
 * Example 2:
 * arr = [3, 2, 1, 5, 4]
 *
 * answer = [1, 2, 2, 3, 3, 4, 4, 5]
 */
public class ClosestNumbers {


    public static List<Integer> closestNumbers(List<Integer> arr) {
        arr.sort(Comparator.naturalOrder());
        int minFreq = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < arr.size()-1; i++) {
            int diff = arr.get(i+1) - arr.get(i);
            minFreq = Math.min(minFreq, diff);

            if (result.containsKey(diff)) {
                result.get(diff).add(arr.get(i));
                result.get(diff).add(arr.get(i+1));
            } else {
                result.put(diff, new ArrayList<>(Arrays.asList(arr.get(i), arr.get(i+1))));
            }
        }

        return result.get(minFreq);
    }
}
