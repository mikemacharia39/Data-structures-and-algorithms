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
     * Solution 3: <a href="https://leetcode.com/problems/divide-two-integers/solutions/6539835/simple-1ms-solution-learn-from-explanation-java-c-python/">...</a>
     * This solution uses a combination of bitwise operations and subtraction to perform division.
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if(divisor == 1) return dividend;
        if(dividend == -1) return -dividend;
        int sign = 1;
        if(dividend>0 && divisor<0) sign = -1;
        if(dividend<0 && divisor>0) sign = -1;

        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        int ans = 0;
        while(n>=d)
        {
            int p = 0;
            while(n >= d<<p)
                p++;

            p--;
            n -= d<<p;
            ans += 1<<p;
        }
        if(ans>=Math.pow(2,31) && sign==1) return Integer.MAX_VALUE;
        if(ans>=Math.pow(2,31) && sign==-1) return Integer.MIN_VALUE;

        return ans*sign;
    }

    /**
     * Solution 2:
     * This solution uses bitwise operations to perform division more efficiently.
     * It finds the largest power of 2 that can be multiplied by the divisor without exceeding the dividend,
     * then subtracts that from the dividend and adds the corresponding power of 2 to the quotient.
     * This approach is more efficient than the brute force method, especially for large numbers.
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide_improved(int dividend, int divisor) {
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return result(dividend, divisor, Integer.MAX_VALUE);
        } else if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return result(dividend, divisor, Integer.MIN_VALUE);
        }

        int answer = 0;

        /**
         * Bitwise Division Using Left Shift (<<)
         * Instead of repeatedly subtracting divisor from dividend,
         * double the divisor at each step using left shifts (d << p).
         * Find the largest power of 2^p where divisor * 2^p is still ≤ dividend.
         * Subtract divisor * 2^p from dividend and add 2^p to the quotient.
         */
        while (absDividend >= absDivisor) {
            int doubler = 0;
            while (absDividend >= absDivisor<<doubler) {
                doubler++;
                doubler--;

                absDividend -= absDivisor<<doubler;
                answer += 1<<doubler;
            }
        }

        return result(dividend, divisor, answer);
    }

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
