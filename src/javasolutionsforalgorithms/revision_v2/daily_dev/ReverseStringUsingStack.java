package javasolutionsforalgorithms.revision_v2.daily_dev;

import java.util.Stack;

public class ReverseStringUsingStack {

    public static String reverseStringUsingStack(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (Character c : str.toCharArray()) {
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String string = reverseStringUsingStack("Hello World");
        System.out.println("Reversed string is: " + string);
    }
}
