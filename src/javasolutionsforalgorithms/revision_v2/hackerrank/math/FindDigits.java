package javasolutionsforalgorithms.revision_v2.hackerrank.math;

/**
 *
 * An integer  is a divisor of an integer  if the remainder of .
 *
 * Given an integer, for each digit that makes up the integer determine whether it is a divisor.
 * Count the number of divisors occurring within the integer.
 *
 * Examples:
 *
 * Example 1:
 * n = 124
 * The number 124 can be broken into 3 digits. When 124 is divided by any of those digits, the remainder is 0.
 * All the 3 digits are divisors so the answer is 3.
 * -----------
 *
 * Example 2:
 * n = 10
 * 10 is evenly divisible by 1 but not 0. The answer is 1.
 */
public class FindDigits {

    public static int findDigits(int n) {
        int count = 0;
        int temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit != 0 && n % digit == 0) {
                count++;
            }
            temp /= 10;
        }
        return count;
    }
}
