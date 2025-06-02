package javasolutionsforalgorithms.revision_v2.leetcode.bitwise;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division,
 * and mod operator.
 *
 * The integer division should truncate toward zero, which means losing its fractional part.
 * For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer
 * range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1,
 * and if the quotient is strictly less than -231, then return -231.
 */
public class DivideTwoIntegers {


    /**
     * Solution 1:
     * This solution uses a brute force approach to repeatedly subtract the divisor from the dividend until the dividend
     * is less than the divisor.
     * This approach is straightforward but inefficient for large numbers, as it may take many iterations.
     * Time complexity: O(n), where n is the absolute value of the dividend.
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide_sln1(int dividend, int divisor) {
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return result(dividend, divisor, Integer.MAX_VALUE);
        } else if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return result(dividend, divisor, Integer.MIN_VALUE);
        }

        int numberOfIterations = 0;
        int start = 0;
        while (absDividend > 0) {
            absDividend -= absDivisor;
            if (absDividend < 0) {
                break;
            }
            numberOfIterations++;
        }

        return result(dividend, divisor, numberOfIterations);
    }

    private int result(int dividend, int divisor, int numberOfIterations) {
        if ((dividend >= 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return numberOfIterations;
        } else {
            return -numberOfIterations;
        }
    }
}
