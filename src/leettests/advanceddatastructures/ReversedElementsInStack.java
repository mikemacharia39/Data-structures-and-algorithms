package leettests.advanceddatastructures;

import java.util.Stack;

public class ReversedElementsInStack {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println("Original: " + stack);

        ReversedElementsInStack reversed = new ReversedElementsInStack();

        System.out.println("Reversed: " + reversed.reverse(stack));
    }

    /**
     * Time complexity if O(n) since we looped as we output elements from stack to the other
     * Space complexity if also O(n) as we added new memory of stack
     * This needs another stack
     * @param stack stack
     * @return stack
     */
    private Stack<Integer> reverse(Stack<Integer> stack) {
        Stack<Integer> reversed = new Stack<>();

        while (!stack.empty()) {
            reversed.push(stack.pop());
        }

        return reversed;
    }
}
