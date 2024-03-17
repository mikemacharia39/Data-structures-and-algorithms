package javasolutionsforalgorithms.revision_v2.hackerrank.dynamic_programming;

import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/coin-change/problem">...</a>
 *
 * Given an amount and the denominations of coins available, determine how many ways change can be made for amount.
 * There is a limitless supply of each coin type.
 *
 * Example:
 * n = 3
 * c = [8,3,2,1]
 *
 * Answer = 3. There are 3 ways to make change for 3: {1,1,1}, {1,2}, and {3}.
 */
public class TheCoinChangeProblem {

    /**
     * Explanation: The logic is to use dynamic programming to solve the problem. The ways array is used to keep track of
     * the different ways to return change. The outer loop is used to iterate through the denominations and the inner loop
     * is used to iterate through the amount. The ways[i] += ways[i - coin] is used to keep track of the different ways to
     * return change.
     * Time complexity = O(n*m) where n is the amount and m is the number of denominations
     * @param n the value
     * @param c the denominations
     * @return the different ways to return change
     */
    public static long getWays(int n, List<Long> c) {
        long[] ways = new long[n+1];
        ways[0] = 1;
        for (long coin : c) {
            for (int i = (int) coin; i <= n; i++) { // start from the coin value until the amount
                ways[i] += ways[i - (int) coin];    // keep track of the different ways to return change
            }
        }
        return ways[n];
    }

    public static void main(String[] args) {
        System.out.println(getWays(3, List.of(8L, 3L, 2L, 1L)));
    }
}
