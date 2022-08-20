package javasolutionsforalgorithms.leettests;

import java.util.Stack;

/**
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
 *
 * https://leetcode.com/problems/valid-parenthesis-string/
 *
 * The following rules define a valid string:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 *
 */
public class ValidParenthesisString678 {
    public static void main(String[] args) {
        ValidParenthesisString678 validParenthesisString678 = new ValidParenthesisString678();

        //String s = "(*))"; // valid since it can be (())
        String s = "*)"; // true -> executed in line 39
        //String s = "*("; // false  -> executed in line 62
        System.out.println(validParenthesisString678.checkValidString(s));
    }

    public boolean checkValidString(String s) {
        Stack<Integer> parenthesisID = new Stack<>();
        Stack<Integer> starID = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                parenthesisID.push(i);
            }
            else if(s.charAt(i) == '*') {
                starID.push(i);
            }
            else {
                if(!parenthesisID.isEmpty()) {
                    parenthesisID.pop();
                } // found matched '('with')'
                else if (!starID.isEmpty()) {
                    starID.pop();
                } // match '*' with ')'
                else {
                    return false;
                } // cannot find match
            }
        }

        // checking leftover on 2 stack
        while(!parenthesisID.isEmpty()) { // we can have '*' leftover, but 'parenthesis' must run out
            if(starID.isEmpty()) {
                return false;
            } // '(' leftover
            else if (parenthesisID.peek() < starID.peek()) {
                parenthesisID.pop();
                starID.pop();
            } // '*'index > '(' index, matched
            else {
                return false;
            } // parenthesis > top, corner case
        }
        return true;
    }
}
