package leettests.stacks;

import java.util.ArrayList;
import java.util.List;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in ***constant time.***
 *
 * Implement the MinStack class:
 *  - MinStack() initializes the stack object.
 *  - void push(int val) pushes the element val onto the stack.
 *  - void pop() removes the element on the top of the stack.
 *  - int top() gets the top element of the stack.
 *  - int getMin() retrieves the minimum element in the stack.
 */
public class MinStackSolutions {

    static class StackNode {
        int val;
        StackNode next;
        int min;

        StackNode(int val) {
            this.val = val;
        }
        StackNode() {
        }
    }

    static class MinStack {

        StackNode head;

        public MinStack() {
            head = new StackNode();
        }

        public void push(int val) {
            StackNode newNode = new StackNode(val);
            newNode.next = head;

            int prevMin = Integer.MAX_VALUE;

            if (head != null) {
                prevMin = head.min;
            }

            newNode.min = Math.min(val, prevMin);

            head = newNode;
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }

    /**
     * using list
     * This works but requires some computation to get the smallest element
     */
    static class MinStackSln2 {
        List<Integer> list;
        public MinStackSln2() {
            list = new ArrayList<>();
        }

        public void push(int val) {
            list.add(val);
        }

        public void pop() {
            list.remove(list.size()-1);
        }

        public int top() {
            return list.get(list.size()-1);
        }

        public int getMin() {
            return list.stream().min(Integer::compare).get();
        }
    }
}
