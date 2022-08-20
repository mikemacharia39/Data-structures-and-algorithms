package javasolutionsforalgorithms.leettests;

import java.util.HashSet;

/**
 * https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
 *
 * Given a linked list, check if the linked list has loop or not. Below diagram shows a linked list with a loop.
 *
 *    1 -> 2 -> 3 -> 4
 *             |     |
 *             7 <- 5
 */

public class IsCyclicLinkedList {

    public static void main(String[] args) {
        IsCyclicLinkedList isCyclicLinkedList = new IsCyclicLinkedList();

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(7);

        System.out.println("IsCyclicLinkedList: " + isCyclicLinkedList.isCyclic(head));

        // To make it circular
        head.next.next.next.next.next.next = new Node(3);

        System.out.println("IsCyclicLinkedList: " + isCyclicLinkedList.isCyclic(head));

    }

    /**
     * Traverse the list one by one and keep putting the node addresses in a Hash Table.
     * At any point, if NULL is reached then return false and if next of current node points to any of
     * the previously stored nodes in Hash then return true.
     *
     * @return true or false
     */
    boolean isCyclic(Node node) {
        HashSet<Integer> hashSet = new HashSet<>();
        while (node != null) {
            if (hashSet.contains(node.value)) {
                return true;
            }
            hashSet.add(node.value);

            node = node.next;
        }
        return false;
    }
}
