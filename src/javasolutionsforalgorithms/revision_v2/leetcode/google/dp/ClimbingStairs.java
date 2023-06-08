package javasolutionsforalgorithms.revision_v2.leetcode.google.dp;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/">...</a>
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 */
public class ClimbingStairs {
    /**
     * The algorithm starts with step1 representing the number of distinct ways to climb 1 step (which is 1),
     * and step2 representing the number of distinct ways to climb 2 steps (which is 2).
     * Then, it iteratively calculates the number of distinct ways at each step by summing up step1 and step2.
     * The idea is to keep count of the variety of ways we can take different steps as at the current position
     * The algorithm stops the iteration at n-1 because step1 and step2 already represent the number of distinct ways
     * for the previous two steps.
     * Finally, it returns step2 if n is greater than 1 (indicating there are at least two steps),
     * otherwise it returns step1 (in case there is only one step).
     * This solution has a time complexity of O(n) and a space complexity of O(1)
     */
    public int climbStairs(int n) {
        int sum = 0;
        int step1 = 1;
        int step2 = 2;
        for (int i = 2; i < n; i++) {
            sum = step1 + step2;
            step1 = step2;
            step2 = sum;
        }
        return n > 1 ? step2 : step1;
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(4));
    }
}
