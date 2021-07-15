package leetTests.arrayandstrings;

/**
 * Perfect Number
 * A perfect number is a positive integer that is equal to the sum of its positive divisors,
 * excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.
 * Given an integer n, return true if n is a perfect number, otherwise return false.
 *
 * Example 1:
 *
 * Input: num = 28
 * Output: true
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, and 14 are all divisors of 28.
 *
 * Example 2:
 *
 * Input: num = 6
 * Output: true
 *
 * Example 3:
 *
 * Input: num = 496
 * Output: true
 */
public class PerfectNumber {

    public static boolean checkPerfectNumber(int num) {

        int sum = 0;
        for (int i = 1; i <= (num/2 + 1); i++) {
            if (num%i == 0 && num != i) {
                sum += i;
            }
        }

        return sum == num;
    }

    public static void main(String[] args) {
        System.out.println("is 28 perfect num: " + checkPerfectNumber(28));
        System.out.println("is 496 perfect num: " + checkPerfectNumber(496));
        System.out.println("is 901 perfect num: " + checkPerfectNumber(901));
    }
}
