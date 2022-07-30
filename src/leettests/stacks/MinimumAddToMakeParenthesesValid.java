package leettests.stacks;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/">...</a>
 * <p>
 * A parentheses string is valid if and only if:
 * <p>
 * It is the empty string,
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
 * <p>
 * For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 * Return the minimum number of moves required to make s valid.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "())"
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: s = "((("
 * Output: 3
 */
public class MinimumAddToMakeParenthesesValid {

    /**
     * Time complexity is O(n)
     * Space complexity O(1)
     * @param s input
     * @return min adj
     */
    public int minAddToMakeValid(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int open = 0;
        int closing = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else if (s.charAt(i) == ')') {
                if (open > 0) {
                    open--;
                } else {
                    closing++;
                }
            }
        }

        return open+closing;
    }

    public int minAddToMakeValid1(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        Deque<Character> stackParenthesis = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case ')':
                    if (!stackParenthesis.isEmpty() && stackParenthesis.peek() == '(') {
                        stackParenthesis.poll();
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

    /**
     * We can use stack for this solution
     * Stack is synchronized, meaning one thread can access at any time
     *
     * @param s input
     * @return count
     */
    public int minAddToMakeValidSln2(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        Stack<Character> stackParenthesis = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
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
