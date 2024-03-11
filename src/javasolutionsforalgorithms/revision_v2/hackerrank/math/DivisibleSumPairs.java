package javasolutionsforalgorithms.revision_v2.hackerrank.math;

import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/divisible-sum-pairs/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=30-day-campaign">...</a>
 *
 * You are given an array of n integers, ar = [ar[0], ar[1], ..., ar[n-1]], and a positive integer, k.
 * ar = [1, 3, 2, 6, 1, 2] and k = 3
 * Find the number of (i, j) pairs where i < j and ar[i] + ar[j] is divisible by k.
 * In this case, there are 5 pairs: (0, 3), (0, 5), (1, 2), (1, 4), and (2, 5).
 */
public class DivisibleSumPairs {
    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {

        int pairs = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if ((ar.get(i) + ar.get(j)) % k == 0) {
                    pairs++;
                }
            }
        }
        return pairs;
    }
}
