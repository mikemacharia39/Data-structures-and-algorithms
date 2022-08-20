package javasolutionsforalgorithms.leettests.linkedLists;

/**
 * https://leetcode.com/problems/split-linked-list-in-parts/
 *
 * Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.
 *
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than one.
 * This may lead to some parts being null.
 *
 * The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a
 * size greater than or equal to parts occurring later.
 *
 * Return an array of the k parts.
 *
 * Example 1:
 *
 * Input: head = [1,2,3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but its string representation as a ListNode is [].
 *
 * Example 2:
 *
 * Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * Output: [[1,2,3,4],[5,6,7],[8,9,10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger
 * size than the later parts.
 */
public class SplitLinkedListInParts {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public ListNode[] splitListToParts(ListNode head, int k) {

        // To count the number of elements in the linked list
        ListNode countElements = head;
        int countAll = 0;
        while (countElements != null) {
            countAll++;
            countElements = countElements.next;
        }

        // items per listNode
        int itemsPerNode = countAll/k;
        // remainder
        int rem = countAll%k;

        if (itemsPerNode == 0) {
            itemsPerNode = 1;
            rem = 0;
        }

        ListNode[] listNode = new ListNode[k];

        if (head == null) {
            return listNode;
        }

        int index = 0;
        while (head != null) {
            ListNode parts = head;

            int hasRemainder = rem <= 0 ? 0 : 1;

            // move the pointer to the size of eachlength
            // items to be set per part
            for(int i = 0; i < itemsPerNode + hasRemainder - 1; i++) {
                head = head.next;
            }

            //set the next to null
            ListNode temp = head.next;
            head.next = null;
            head = temp;

            //add to the result array
            listNode[index++] = parts;

            // decrement the remainder length
            rem--;
        }

        return listNode;
    }
}
