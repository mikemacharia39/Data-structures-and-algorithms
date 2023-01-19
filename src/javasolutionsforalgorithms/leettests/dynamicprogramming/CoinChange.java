package javasolutionsforalgorithms.leettests.dynamicprogramming;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/coin-change/">...</a>
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount
 * representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 */
public class CoinChange {

    // https://www.youtube.com/watch?v=jl68j3vLHZk
    public int coinChange(int[] coins, int amount) {
        int rows = coins.length + 1;
        int cols = amount + 1;

        int[][] dp = new int[rows][cols];

        // initialize 1st row with INFINITE
        for (int j = 0; j < cols; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1; // to prevent it from going out of bounds
        }

        // we are starting at index 1 because we have already filled index 0
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                // if denomination > amount
                if (coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j]; // take the data entry from above
                } else {
                    // you can choose to take previous denomination or
                    // or current denomination + balance
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }
        // last cell otherwise -1 if INFINITE
        return dp[rows-1][cols-1] < Integer.MAX_VALUE - 1 ? dp[rows-1][cols-1] : -1;
    }


    /**
     * Brute force does not work
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_doesNotWork(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Arrays.sort(coins);

        int n = coins.length;
        int count = 0;
        int start = 1;
        while (amount > 0) {
            for (int i = n - start; i >= 0; i--) {
                if (amount >= coins[i]) {
                    int multiple = multiples(amount, coins[i]);
                    amount = amount - (coins[i] * multiple);
                    count += multiple;
                }
            }

            if (amount != 0 && start < n - 1) {
                start++;
            } else if (amount == 0) {
                break;
            } else {
                count = -1;
                break;
            }
        }

        return count;
    }

    private int multiples(int amount, int coin) {
        return (int) amount/coin;
    }

}
