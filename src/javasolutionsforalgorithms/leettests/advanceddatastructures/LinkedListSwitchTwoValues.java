package javasolutionsforalgorithms.leettests.advanceddatastructures;

/**
 * Switch the posision
 */
public class LinkedListSwitchTwoValues {
    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static void main(String[] args) {
        LinkedListSwitchTwoValues switchPosition = new LinkedListSwitchTwoValues();

        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        int left = 2;

        int right = 4;

        System.out.print("Cur: ");
        switchPosition.print(head);

        System.out.println();

        ListNode ans = switchPosition.reverseBetween(head, left, right);

        System.out.print("New: ");
        switchPosition.print(ans);
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "\t");

            head = head.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null) {
            return head;
        }

        ListNode cur = head;

        while (cur != null) {
            if (cur.val == left) {
                cur.val = right;
                cur = cur.next;
            } else if (cur.val == right) {
                cur.val = left;
                cur = cur.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

}
