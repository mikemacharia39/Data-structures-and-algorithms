package javasolutionsforalgorithms.revision_v2.general.collection;

import java.util.Stack;

public class ReverseStack {

    public static Stack<Integer> reverseStackUsingStack(Stack<Integer> stack) {
        Stack<Integer> reversed = new Stack<>();
        while (!stack.isEmpty()) {
            reversed.push(stack.pop());
        }
        return reversed;
    }

    public static void main(String[] args) {
        ReverseStack obj = new ReverseStack();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("stack = " + stack);
        Stack<Integer> reversed = obj.reverseStackUsingStack(stack);
        System.out.println("reversed = " + reversed);
    }
}
