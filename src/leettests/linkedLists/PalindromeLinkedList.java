package leettests.linkedLists;

/**
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

    public boolean isPalindrome(ListNode head) {

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


}
