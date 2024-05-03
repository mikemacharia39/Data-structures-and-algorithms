package javasolutionsforalgorithms.revision_v2.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: s = "(]"
 * Output: false
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(c); //similar to stack.addFirst()
                    }
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                    break;
                default:
                    stack.push(c);
            }
        }

        return stack.isEmpty();
    }


    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                    break;
                default:
                    stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = "()[]{}}";
        ValidParentheses obj = new ValidParentheses();
        System.out.println(obj.isValid(input));

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a set of parentheses: ");
            String input1 = scanner.nextLine();
            System.out.println(obj.isValid(input1));

            System.out.println("Do you want to continue? (Y/N)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("N")) {
                break;
            }
        }
    }
}
