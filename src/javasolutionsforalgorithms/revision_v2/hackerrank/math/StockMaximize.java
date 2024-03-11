package javasolutionsforalgorithms.revision_v2.hackerrank.math;

import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/stockmax/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=7-day-campaign">...</a>
 *
 * Your algorithms have become so good at predicting the market that you now know what the share price of Wooden Orange
 * Toothpicks Inc. (WOT) will be for the next number of days.
 *
 * Each day, you can either buy one share of WOT, sell any number of shares of WOT that you own, or not make any
 * transaction at all. What is the maximum profit you can obtain with an optimum trading strategy?
 *
 * Example
 * prices = [1, 2]
 * Buy one share day one, and sell it day two for a profit of 1. Return 1.
 *
 * prices = [2, 1]
 * No profit can be made so you do not buy or sell stock those days. Return 0.
 *
 * Function Description
 *
 * Complete the stockmax function in the editor below.
 *
 * stockmax has the following parameter(s):
 *
 * prices: an array of integers that represent predicted daily stock prices
 * Returns
 *
 * int: the maximum profit achievable
 */
public class StockMaximize {

    /**
     * Logic is to start from the end and keep track of the max price so far and then calculate the profit
     * @param prices
     * @return
     */
    public static long stockmax(List<Integer> prices) {

        long profit = 0;
        int currentProfit = 0;
        for (int i = prices.size() - 1; i >= 0; i--) {
            currentProfit = Math.max(currentProfit, prices.get(i)); //100,100
            profit += Math.max(0, currentProfit - prices.get(i));   //0,98,197
        }

        return profit;
    }

    public static void main(String[] args) {
        System.out.println(stockmax(List.of(1, 2, 100)));
    }
}
