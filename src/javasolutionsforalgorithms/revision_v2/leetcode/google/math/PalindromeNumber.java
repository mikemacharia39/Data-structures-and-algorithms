package javasolutionsforalgorithms.revision_v2.leetcode.google.math;

/**
 * <a href="https://leetcode.com/problems/palindrome-number/">...</a>
 *
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 */
public class PalindromeNumber {

    /**
     * Time complexity: O(n)
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x == 0) {
            return true;
        }

        if (x % 10 == 0) {
            return false;
        }

        int duplicate = x;

        int sum = 0;
        while (duplicate > 0) {
            int modulus = duplicate % 10;
            duplicate /= 10;

            sum = (sum * 10) + modulus;
        }

        return x == sum;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();

        int[] testNumbers = {121, -121, 345676543};

        for (int num : testNumbers) {
            System.out.println("Is " + num + " a palindrome number? " + palindromeNumber.isPalindrome(num));
        }
    }
}
