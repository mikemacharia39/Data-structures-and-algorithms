package javasolutionsforalgorithms.revision_v2.leetcode.leetcode.dp;

/**
 *
 * <a href="https://leetcode.com/problems/min-cost-climbing-stairs/">...</a>
 *
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 *
 * Example 1:
 *
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * Example 2:
 *
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 */
public class MinCostClimbingStairs {

    /**
     * From where we are consider one step back and a step infront
     * Using this example [10,15,20]
     * prev = 10, curr = 15
     * sum = 20 + Math.min(10,15) = 30
     * prev = 15
     * curr = 30
     * Math.min (15,30) = 15
     */
    public int minCostClimbingStairs1(int[] cost) {
        int sum = 0;
        int prev = cost[0];
        int curr = cost[1];
        for (int i = 2; i < cost.length; i++) {
            sum = cost[i] + Math.min(prev, curr);
            prev = curr;
            curr = sum;
        }
        return Math.min(prev, curr);
    }
}
