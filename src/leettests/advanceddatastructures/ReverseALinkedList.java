package leettests.advanceddatastructures;

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 */
public class ReverseALinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ReverseALinkedList reverseALinkedList = new ReverseALinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original: ");

        reverseALinkedList.print(head);

        System.out.println();

        ListNode ans = reverseALinkedList.reverseList(head);

        System.out.print("Reversed: ");

        reverseALinkedList.print(ans);
    }

    void print(ListNode node) {

        while (node != null) {
            System.out.print(node.val  + " -> ");

            node = node.next;
        }
    }

    /**
     * Given a linked list write an algorithm to reverse it.
     * @param head Linked list
     * @return reversed
     */
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;

        while (head != null) {

            ListNode next = head.next; // 2, 3

            head.next = prev; // null <- 1 <-

            prev = head; // null <- 1 <- 2 <-

            head = next; // 2, 3
        }

        return prev;
    }

}
