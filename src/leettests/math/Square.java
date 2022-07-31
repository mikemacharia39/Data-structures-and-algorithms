package leettests.math;

/**
 * <a href="https://leetcode.com/problems/sqrtx/">...</a>
 *
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer,
 * the decimal digits are truncated, and only the integer part of the result is returned.
 *
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 */
public class Square {

    /**
     * Using binary search
     * @param x actual square
     * @return the num ^ 2
     */
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int low = 1;
        int high = x;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (mid == x/mid) {   // you could also do mid * mid == x, but this is better
                return mid;
            }
            
            if (mid > x/mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low - 1; // very important (assuming x = 8 the application will exit loop when low == high = 3)
    }

    public int mySqrt1(int x) {
        if (x < 2) {
            return x;
        }

        int ans = 1;
        int n = (int)Math.ceil((double)x/2);

        for (int i = 2; i <= n; i++) {
            long val = (long) i * i;
            if (val == x) {
                ans = i;
                break;
            } else if (val > x) {
                ans = i-1;
                break;
            }
        }

        return ans;
    }
}
