package javasolutionsforalgorithms.leettests.linkedLists;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 *
 * Example 2:
 *
 * Input: head = []
 * Output: []
 *
 * Example 3:
 *
 * Input: head = [1]
 * Output: [1]
 */
public class SwapNodesInPairs {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return swap(head);
    }

    public ListNode swap(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;    // 2 -> 4

        head.next = swap(next.next);  // 3 -> null

        next.next = head;             // 1 -> 3

        return next;
    }
}
