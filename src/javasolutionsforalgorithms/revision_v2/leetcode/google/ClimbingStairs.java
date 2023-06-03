package javasolutionsforalgorithms.revision_v2.leetcode.google;

public class ClimbingStairs {
    /**
     * The algorithm starts with step1 representing the number of distinct ways to climb 1 step (which is 1),
     * and step2 representing the number of distinct ways to climb 2 steps (which is 2).
     * Then, it iteratively calculates the number of distinct ways at each step by summing up step1 and step2.
     * In each iteration, it updates step1 with the previous step2 value, and step2 with the newly calculated sum.
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
}
