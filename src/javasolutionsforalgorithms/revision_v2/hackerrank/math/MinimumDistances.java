package javasolutionsforalgorithms.revision_v2.hackerrank.math;

import java.util.List;

/**
 * The distance between two array values is the number of indices between them.
 * Given an array, find the minimum distance between any pair of equal elements in the array. If no such value exists, return -1.
 *
 * Example:
 * arr = [3, 2, 1, 2, 3]
 * answer = 2, because the minimum distance between 2 and 2 is 2
 *
 */
public class MinimumDistances {

    /**
     * Time complexity: O(n) because we are using lastIndexOf method which is O(n)
     * @param a list of integers
     * @return the minimum distance between any pair of equal elements in the array
     */
    public static int minimumDistances(List<Integer> a) {
        int n = a.size();
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            int nextIndex = a.lastIndexOf(a.get(i));
            if (i != nextIndex) {
                minDistance = Math.min(minDistance, nextIndex - i);
            }
        }
        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
    }

    /**
     * Unfortunately, this solution DOES NOT work and is not efficient
     * Time complexity: O(n^2)
     * @param a list of integers
     * @return the minimum distance between any pair of equal elements in the array
     */
    public static int minimumDistances1(List<Integer> a) {

        int n = a.size();
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a.get(i) == a.get(j)) {
                    int diff = j - i;
                    minDistance = Math.min(minDistance, diff);
                }
            }
        }
        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
    }
}
