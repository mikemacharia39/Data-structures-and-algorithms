package javasolutionsforalgorithms.revision_v2.daily_dev;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This class demonstrates how to reverse a string using Deque.
 * Deque is a double-ended queue that supports element insertion and removal at both ends.
 * Deque also allows for unsynchronized access to elements.
 */
public class ReverseStringUsingDeque {
    public static String reverseStringUsingDeque(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (Character c : str.toCharArray()) {
            // Inserts the specified element at the front of this deque if it is possible to do so
            deque.addFirst(c); // you can use deque.offerFirst(c) as well which is much safer
        }

        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst()); // you can use deque.pollFirst() as well which is much safer
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String reversedString = reverseStringUsingDeque("Hello World");
        System.out.println("Reversed string: " + reversedString);
    }
}
