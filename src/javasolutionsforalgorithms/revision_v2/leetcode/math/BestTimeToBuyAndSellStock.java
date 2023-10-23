package javasolutionsforalgorithms.revision_v2.leetcode.math;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">...</a>
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to
 * sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class BestTimeToBuyAndSellStock {

    /**
     * Time complexity: O(n)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int leastPriceSoFar = Integer.MAX_VALUE;
        int overallPrice = 0;
        int priceIfSoldToday = 0;

        for (int price : prices) {
            if (price < leastPriceSoFar) {
                leastPriceSoFar = price;
            }

            priceIfSoldToday = price - leastPriceSoFar;

            if (overallPrice < priceIfSoldToday) {
                overallPrice = priceIfSoldToday;
            }
        }

        return overallPrice;
    }

    /**
     * Usind 2 ptr; time limit exceed
     */
    public int maxProfitSln1(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    max = Math.max(max, prices[j] - prices[i]);
                }
            }
        }
        return max;
    }
}
