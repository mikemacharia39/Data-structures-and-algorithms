package leettests.stacks;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/">...</a>
 *
 * A parentheses string is valid if and only if:
 *
 * It is the empty string,
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
 *
 * For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 * Return the minimum number of moves required to make s valid.
 *
 * Example 1:
 *
 * Input: s = "())"
 * Output: 1
 *
 * Example 2:
 *
 * Input: s = "((("
 * Output: 3
 */
public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        Stack<Character> stackParenthesis = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case ')':
                    if (!stackParenthesis.empty() && stackParenthesis.peek() == '(') {
                        stackParenthesis.pop();
                    } else {
                        stackParenthesis.push(')');
                    }
                    break;
                default:
                    stackParenthesis.push('(');
                    break;
            }
        }

        return stackParenthesis.size();
    }
}
