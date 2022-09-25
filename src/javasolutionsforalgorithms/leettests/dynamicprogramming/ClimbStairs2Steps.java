package javasolutionsforalgorithms.leettests.dynamicprogramming;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/">...</a>
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 *
 * 1 <= n <= 45
 */
public class ClimbStairs2Steps {

    /**
     * The idea behind this is recursive
     * if 1 = 1
     * if 2 = [{1, 1}, {2}]
     * if 3 = [{1,1,1}, {1,2}, {2,1}]
     * if 4 = [{1,1,1,1},{1,1,2},{1,2,1},{2,1,1},{2,2}]
     *
     * if you hop 1, you're left with n-1 steps
     * if you hop 2, you're left with n-2 steps
     */
    public int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }

        return climbStairs1(n-1) + climbStairs1(n-2);
    }
}
