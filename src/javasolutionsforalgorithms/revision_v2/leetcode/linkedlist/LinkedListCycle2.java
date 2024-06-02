package javasolutionsforalgorithms.revision_v2.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
 * following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
 * is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 *
 * Do not modify the linked list.
 */
public class LinkedListCycle2 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            if (nodes.contains(head)) {
                return head;
            } else {
                nodes.add(head);
            }
            head = head.next;
        }

        return null;
    }

    /**
     *
     * You can solve this problem using Floyd's cycle-finding algorithm,
     * also known as the "tortoise and the hare" algorithm.
     * This algorithm uses two pointers, one that moves two steps at a time (fast), and another that moves one step at a time (slow).
     * If there is a cycle, these two pointers will meet at some point.
     * After the fast and slow pointers meet, we reset the slow pointer to the head of the list and keep the fast pointer at the
     * meeting point. Then, we move both pointers one step at a time.
     * The point where they meet again is the start of the cycle.
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Find the meeting point
        do {
            if (fast == null || fast.next == null) {
                return null; // No cycle
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        // Find the start of the cycle
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        LinkedListCycle2 obj = new LinkedListCycle2();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(-4);
        System.out.println("The Value: " + obj.detectCycle(head).val);

        // Test 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2;
        System.out.println("The Value: " + obj.detectCycle(head2).val);
    }
}
