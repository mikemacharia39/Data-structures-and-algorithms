package leettests.linkedLists;

import java.util.HashSet;
import java.util.Set;

/**
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
 * following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
 * is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 *
 * Input: head = [3,2,0,-4], pos = 1
 *
 *  3 -> 2 -> 0 -> -4
 *       ^          |
 *       |__________|
 *
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 */
public class LinkedListCycleTwo {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        Set<ListNode> nodes = new HashSet<>();
        while(head != null) {
            if (nodes.contains(head)) {
                return head;
            } else {
                nodes.add(head);
            }
            head = head.next;
        }
        return null;
    }
}
