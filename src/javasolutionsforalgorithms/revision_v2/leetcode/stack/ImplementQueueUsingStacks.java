package javasolutionsforalgorithms.revision_v2.leetcode.stack;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/implement-queue-using-stacks/">...</a>
 *
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the
 * functions of a normal queue (push, peek, pop, and empty).
 *
 * Implement the MyQueue class:
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size,
 * and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque
 * (double-ended queue) as long as you use only a stack's standard operations.
 */
public class ImplementQueueUsingStacks {

    public Stack<Integer> stack;
    public ImplementQueueUsingStacks() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        if (!empty()) {
            Stack<Integer> stackRev = new Stack<>();
            while (!stack.isEmpty()) {
                stackRev.push(stack.pop());
            }
            int lastIn = stackRev.pop();

            while (!stackRev.empty()) {
                stack.push(stackRev.pop());
            }

            return lastIn;
        }
        return 0;
    }

    public int peek() {
        if (!empty()) {
            Stack<Integer> stackRev = new Stack<>();
            while (!stack.isEmpty()) {
                stackRev.add(stack.pop());
            }
            int lastIn = stackRev.peek();

            while (!stackRev.empty()) {
                stack.push(stackRev.pop());
            }

            return lastIn;
        }
        return 0;
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks obj = new ImplementQueueUsingStacks();
        obj.push(1);
        obj.push(3);
        obj.push(5);

        System.out.println(obj.peek());// we expect to see 1

        System.out.println(obj.pop());// we will get 1

        System.out.println(obj.empty()); // false

        obj.push(7);

        System.out.println(obj.pop()); // we expect to see 3
    }
}
