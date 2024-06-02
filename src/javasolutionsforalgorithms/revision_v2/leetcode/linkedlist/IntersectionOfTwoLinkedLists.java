package javasolutionsforalgorithms.revision_v2.leetcode.linkedlist;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 *
 * For example, the following two linked lists begin to intersect at node c1:
 *
 *       a1 -> a2 ->
 *                   c1 -> c2 -> c3
 * b1 -> b2 -> b3 ->
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5].
 * There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * - Note that the intersected node's value is not 1 because the nodes with value 1 in A and B
 * (2nd node in A and 3rd node in B) are different node references.
 * In other words, they point to two different locations in memory,
 * while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory
 */
public class IntersectionOfTwoLinkedLists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) {
            return null;
        }

        int lenA = nodeLength(headA);
        int lenB = nodeLength(headB);

        // move the longer list to the same length as the shorter list
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        // move both lists until they intersect
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int nodeLength(ListNode node) {
        int len = 0;

        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }
}
