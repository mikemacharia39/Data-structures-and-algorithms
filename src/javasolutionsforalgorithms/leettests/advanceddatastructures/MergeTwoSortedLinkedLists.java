package javasolutionsforalgorithms.leettests.advanceddatastructures;

/**
 * Merge two sorted linked lists and return it as a sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 *
 * Example 1:
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 * Input: l1 = [], l2 = []
 * Output: []
 *
 * Example 3:
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 */
public class MergeTwoSortedLinkedLists {

    /**
     * Definition for singly-linked list.
     */
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    /**
     * https://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
     *
     * The strategy here uses a temporary dummy node as the start of the result list.
     * The pointer Tail always points to the last node in the result list,
     * so appending new nodes is easy.
     * The dummy node gives the tail something to point to initially when the result list is empty.
     * This dummy node is efficient, since it is only temporary, and it is allocated in the stack.
     * The loop proceeds, removing one node from either ‘a’ or ‘b’, and adding it to the tail.
     * When We are done, the result is in dummy.next.
     *
     * --------------------------------------------
     * Time complexity = O (m + n) because we are looping through two lists
     * Space complexity is O (m)
     *
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode p, node = new ListNode(0);
        p = node;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        p.next = (l1 == null) ? l2 : l1;

        return node.next;
    }

    public static void main(String[] args) {

    }
}
