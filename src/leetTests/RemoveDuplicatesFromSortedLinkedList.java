package leetTests;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveDuplicatesFromSortedLinkedList {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedLinkedList removeDuplicates = new RemoveDuplicatesFromSortedLinkedList();

        ListNode listNode = new ListNode();
        listNode.val = 2;

        ListNode lists = new ListNode(2, listNode);

        removeDuplicates.deleteDuplicates(lists);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode list = head;

        if (list == null || list.next == null) {
            return list;
        }

        while (list != null) {
            if (list.next == null) {
                break;
            }
            if (list.val == list.next.val) {
                list.next = list.next.next;
            } else {
                list = list.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicatesSoln1(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            return head.next;
        } else {
            return head;
        }
    }
}
