package leettests.linkedLists;

/**
 * <a href="https://leetcode.com/problems/palindrome-linked-list/">...</a>
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 * Example 1:
 *
 * Input: head = [1,2,2,1]
 * Output: true
 *
 *
 * Example 2:
 *
 * Input: head = [1,2]
 * Output: false
 */
public class PalindromeLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Approach:
     * 1 -> 2 -> 2 -> 1
     * Find the middle of the linked list (results in 2 -> 1)
     * Reverse the slow pointer node      (results in 1 -> 2)
     * Compare the val of head with the slow node
     * @param head root
     * @return true|false
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {return true;}

        ListNode mid = reverse(mid(head));

        while (mid != null) {
            if (mid.val != head.val) {
                return false;
            }
            head = head.next;
            mid = mid.next;
        }
        return true;
    }

    /**
     * To find the middle of the linked list
     * To find the middle, use 2 pointer:
     * A slow pointer moving step by step and a fast pointer moving 2 times faster than the slow pointer
     *
     * @param head root
     * @return mid
     */
    public ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;

            // the actual reversal of linked list
            head.next = prev;
            // assigning the current node
            prev = head;
            // assigning the next value
            head = next;
        }
        return prev;
    }
}
