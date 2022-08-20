package javasolutionsforalgorithms.leettests.math;

/**
 * <a href="https://leetcode.com/problems/powx-n/">...</a>
 *
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 * Example 1:
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 *
 * Example 2:
 *
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 *
 * Example 3:
 *
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
public class PowerN {
    public double myPow(double x, int n) {

        if (n < 0) {
            return 1/power(x,Math.abs(n));
        } else {
            return power(x,n);
        }

    }

    /**
     * 2^5 = 5/2 = 2 (2*2*2) then  2/2 = 1  (2*2) = 32
     *
     *
     */
    private double power(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double ans = power(x, n/2);

        if (n%2 == 0) {
            return ans * ans;
        } else {
            return ans * ans * x;
        }
    }
}
