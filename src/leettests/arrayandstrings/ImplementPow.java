package leettests.arrayandstrings;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * Example 1:
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 *
 * Example 2:
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 *
 * Example 3:
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
public class ImplementPow {

    /**
     * x^n can be treated as x * x^n-1  -> O(n)
     * or
     * x^n can be treated as x^n/2 * x^n/2 for even power --
     *                                                     | -> time complexity 0(log(n))
     *                 or as x * x^n-1 of      odd power  --
     *
     * @param x base
     * @param n power
     * @return ans
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1/power(x,Math.abs(n));
        } else {
            return power(x,n);
        }
    }


    /**
     * The solution divides the power until power is 0
     * i.e. x * x ^ n-1
     * i.e. x ^ 8 -> x ^ 7 -> x -> 6 -> 5 -> 4 ..... 0
     *
     * Time complexity is  0 (n)
     *
     * @param x base
     * @param n power
     * @return ans
     */
    private double power1(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double ans = power(x, n-1);
        return ans * x;
    }


    /**
     * The solution divides the power until power is 0
     * i.e. x ^ n = x ^ n/2 * x ^ n/2  if even
     *              x * x ^ n-1        if odd
     * i.e. x ^ 8 -> x ^ 4 -> x -> 2 -> x -> 1
     *
     * Time complexity is  0 (log(n))
     *
     * @param x base
     * @param n power
     * @return ans
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

    public static void main(String[] args) {
        ImplementPow pow = new ImplementPow();
        // 1.00000
        //-2147483648
        System.out.println("pow.myPow(1.00, -2147483648) Ans: " + pow.myPow(1.00, -2147483648));

        System.out.println("pow.myPow(2.00, 5) Ans: " + pow.myPow(2.00, 5));
    }
}
