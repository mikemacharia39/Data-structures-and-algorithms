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

    /**
     * Explanation: Ths involves finding the length of both list node and adjusting both such that each start at the same
     * length.
     * Then checking the node where the 2 are equal
     * Time complexity: O(N) the longest length
     * @param headA ListNode
     * @param headB ListNode
     * @return intersection
     */
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

    /**
     * In order to solve this problem with only O(1) extra space, we'll need to find another way to align the two linked lists.
     * More importantly, we need to find a way to line up the ends of the two lists.
     * And the easiest way to do that is to concatenate them in opposite orders, A+B and B+A. This way, the ends of the two original
     * lists will align on the second half of each merged list.
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
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
