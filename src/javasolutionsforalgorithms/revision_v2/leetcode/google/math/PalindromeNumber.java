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
        int duplicate = x;

        int sum = 0;
        while (duplicate > 0) {
            int modulus = duplicate % 10;

            sum = (sum * 10) + modulus;

            duplicate /= 10;
        }

        return x == sum;
    }
}
