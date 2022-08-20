package javasolutionsforalgorithms.leettests;

public class MiddleOfLinkedList {

    public static void main(String[] args) {

        MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Current: ");
        middleOfLinkedList.print(head);

        System.out.println();
        ListNode ans = middleOfLinkedList.middleNode(head);

        System.out.print("Middle: ");
        middleOfLinkedList.print(ans);
    }

    void print(ListNode node) {

        while (node != null) {
            System.out.print(node.val  + " -> ");

            node = node.next;
        }
    }

    public ListNode middleNode(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode headCounter = head;

        int size = 0;

        while (headCounter != null) {
            size++;

            headCounter = headCounter.next;
        }

        int mid = (int) Math.ceil(size/2);

        for (int i = 0; i < mid; i++) {
            head = head.next;
        }

        return head;
    }
}
