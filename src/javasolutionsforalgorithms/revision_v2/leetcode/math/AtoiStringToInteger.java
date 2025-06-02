package javasolutionsforalgorithms.revision_v2.leetcode.math;

/**
 * <a href="https://leetcode.com/problems/string-to-integer-atoi/">...</a>
 *
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
 * <p>
 * The algorithm for myAtoi(string s) is as follows:
 * <p>
 * Whitespace: Ignore any leading whitespace (" ").
 * Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
 * Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the
 * string is reached. If no digits were read, then the result is 0.
 * Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain
 * in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should
 * be rounded to 231 - 1.
 * Return the integer as the final result.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "42"
 * <p>
 * Output: 42
 * <p>
 * Explanation:
 * The underlined characters are what is read in and the caret is the current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 * ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 * ^
 * Step 3: "42" ("42" is read in)
 * ^
 * <p>
 * Example 2:
 * Input: s = " -042"
 * Output: -42
 * <p>
 * Explanation:
 * Step 1: "   -042" (leading whitespace is read and ignored)
 * ^
 * Step 2: "   -042" ('-' is read, so the result should be negative)
 * ^
 * Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
 */
public class AtoiStringToInteger {
    public int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        // remove leading and trailing spaces
        s = s.trim();

        int n = s.length();

        if (s.isEmpty()) {
            return 0;
        }
        if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        }
        if (s.charAt(0) == '+') {
            i++;
        }

        long result = 0;
        while (i < n) {
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }
            result = result * 10 + (s.charAt(i) - '0');

            if ((result * sign) >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if ((result * sign) <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }

        return (int) (result * sign);
    }
}
