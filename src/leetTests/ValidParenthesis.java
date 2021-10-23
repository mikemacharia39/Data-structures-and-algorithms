package leetTests;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 */
public class ValidParenthesis {

    public static void main(String[] args) {
//        String s = "()";
//        Output: true
//        Example 2:

        String s = "()[]{}";
//        Output: true
//        Example 3:

//        String s = "(]";
//        Output: false
//        Example 4:

//        String s = "([)]";
//        Output: false

        ValidParenthesis validParenthesis = new ValidParenthesis();
        System.out.println(validParenthesis.isValid(s));
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case '}':
                    if (!stack.empty() && stack.peek().equals('{')) {
                        stack.pop();
                    } else {
                        stack.push('}');
                    }
                    break;
                case ']':
                    if (!stack.empty() && stack.peek().equals('[')) {
                        stack.pop();
                    } else {
                        stack.push(']');
                    }
                    break;
                case ')':
                    if (!stack.empty() && stack.peek().equals('(')) {
                        stack.pop();
                    } else {
                        stack.push(')');
                    }
                    break;

                default:
                    stack.push(s.charAt(i));
                    break;

            }

        }

        return stack.empty();

    }
}
