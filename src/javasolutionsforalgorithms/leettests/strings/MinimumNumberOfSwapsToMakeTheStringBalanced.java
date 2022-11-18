package javasolutionsforalgorithms.leettests.strings;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/">...</a>
 * Example 1:
 *
 * Input: s = "][]["
 * Output: 1
 * Explanation: You can make the string balanced by swapping index 0 with index 3.
 * The resulting string is "[[]]".
 *
 * Example 2:
 * Input: s = "]]][[["
 * Output: 2
 * Explanation: You can do the following to make the string balanced:
 * - Swap index 0 with index 4. s = "[]][][".
 * - Swap index 1 with index 5. s = "[[][]]".
 * The resulting string is "[[][]]".
 * Example 3:
 *
 * Input: s = "[]"
 * Output: 0
 * Explanation: The string is already balanced.
 */
public class MinimumNumberOfSwapsToMakeTheStringBalanced {

    public int minSwapsStack(String s) {
        int unmatched = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                stack.push('[');
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    unmatched++;
                }
            }
        }

        // round up if decimal, division by 2 because of swaps
        return (int) Math.ceil((double) unmatched/2);
    }
}
