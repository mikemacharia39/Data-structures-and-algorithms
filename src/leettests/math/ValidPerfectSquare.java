package leettests.math;

/**
 * <a href="https://leetcode.com/problems/valid-perfect-square/">...</a>
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Follow up: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: num = 16
 * Output: true
 *
 * Example 2:
 *
 * Input: num = 14
 * Output: false
 *
 * Example 3:
 *
 * Input: num = 1
 * Output: true
 *
 * Example 4:
 *
 * Input: num = 2147483647
 * Output: false
 */
public class ValidPerfectSquare {

    /**
     * Time limit exceeded
     */
    public boolean isPerfectSquare1(int num) {
        if (num == 1) {
            return true;
        }
        if (num < 4) {
            return false;
        }

        int x = num/2;
        for (int i = 1; i <= x; i++) {
            long sq =   1L * i * 1L * i;
            if (sq == num) {
                return true;
            }
        }

        return false;
    }
}
