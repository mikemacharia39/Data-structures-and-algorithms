package javasolutionsforalgorithms.leettests.advanceddatastructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseElementsInQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        ReverseElementsInQueue reverse = new ReverseElementsInQueue();

        System.out.print("Initial Values: ");
        reverse.printQueue(queue);

        Queue<Integer> reversed =  reverse.reverse(queue);

        System.out.println();

        System.out.print("Reversed Values: ");
        reverse.printQueue(reversed);
    }

    void printQueue(Queue<Integer> queue) {
        System.out.println(queue);
    }

    /**
     * Time complexity is O(n) since we stored the elements to a stack and later to the queue
     * space complexity is O(n) since we used a stack to store the elements
     * @param queue
     * @return
     */
    private Queue<Integer> reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        // Items in the queue will be output from the topmost to the bottom most
        // therefore in the stack the top value will bottom value of the queue
        // 5, 4, 3, 2, 1
        while (!(queue.isEmpty())) {
            stack.push(queue.poll());
        }

        while (!(stack.isEmpty())) {
            queue.add(stack.pop());
        }

        return queue;
    }
}
