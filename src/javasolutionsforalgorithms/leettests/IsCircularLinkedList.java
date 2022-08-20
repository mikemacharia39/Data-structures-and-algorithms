package javasolutionsforalgorithms.leettests;

/**
 * https://www.geeksforgeeks.org/check-if-a-linked-list-is-circular-linked-list/
 *
 * Given a singly linked list, find if the linked list is circular or not.
 * A linked list is called circular if it is not NULL-terminated and all nodes are connected in the form of a cycle.
 *
 *   -> 1 -> 2 -> 3 -> 5 -|
 *   |<-------------------
 *
 */

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

public class IsCircularLinkedList {

    public static void main(String[] args) {

        Node node;
        node = new Node(2);
        node.next = new Node(3);
        node.next.next = new Node(5);

        // Making linked list circular
        node.next.next.next = node;

        IsCircularLinkedList isCircularLinkedList = new IsCircularLinkedList();

        boolean status = isCircularLinkedList.isCircular(node);

        System.out.println("Is Cyclic: " + status);
    }

    /**
     * This function returns true if given linked
     * list is circular, else false.
     */
    boolean isCircular(Node head) {

        // By default if a linked list is null then it is circular
        if (head == null) {
            return true;
        }

        Node node = head.next;

        // check if head is not null and the current node = head
        while(node != null && node != head) {

            node = node.next;

            return (node == head);
        }
        return false;
    }
}
