package javasolutionsforalgorithms.leettests.recursion;

/**
 * <a href="https://leetcode.com/problems/n-th-tribonacci-number/">...</a>
 *
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 *
 * Constraints:
 *
 * 0 <= n <= 37
 * The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 */
public class NthTribonacciNumber {
    public int tribonacci(int n) {
        if (n < 2) return n;
        int a = 0, b = 1, c = 1, d;
        while (n-- > 2) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }

    /**
     * use cache to calculate
     * @param n number
     * @return output
     */
    public int tribonacci_cache(int n) {
        int[] cache = new int[n+1];

        if (n == 0) {
            return 0;
        }

        if (n <= 2) {
            return 1;
        }

        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 1;

        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i-3] + cache[i-2] + cache[i-1];
        }

        return cache[n];
    }
}
