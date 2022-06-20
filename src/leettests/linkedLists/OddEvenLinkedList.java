package leettests.linkedLists;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the head of a singly linked list, group all the nodes with odd
 * indices together followed by the nodes with even indices, and return the reordered list.
 *
 * The first node is considered odd, and the second node is even, and so on.
 *
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 *
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 *
 * Example 1:
 *
 * 1 -> 2 -> 3 -> 4 -> 5
 *
 * 1 -> 3 -> 5 -> 2 -> 4
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 *
 */
public class OddEvenLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = head;          // 1
        ListNode even = head.next;    // 2
        ListNode evenHead = even;     // 2

        while (odd.next != null && even.next != null) {
            odd.next = even.next;  // 3 -> 5
            odd = odd.next;        // 3 -> 5
            even.next = odd.next;  // 3 -> 6
            even = even.next;      // 4 -> 6
        }

        odd.next = evenHead;       // 1, 3, 5 -> 2, 4

        return head;
    }

    List print(ListNode node) {
        List<Integer> integerList = new ArrayList<>();
        while (node != null) {
            integerList.add(node.val);
            node = node.next;
        }
        return integerList;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();


        System.out.printf("Before reorder %s%n", oddEvenLinkedList.print(root));

        System.out.printf("After reorder  %s%n", oddEvenLinkedList.print(oddEvenLinkedList.oddEvenList(root)));
    }
}
