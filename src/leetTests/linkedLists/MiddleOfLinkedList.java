package leetTests.linkedLists;

/**
 * To find the middle of linked list i.e. elements from the middle to the right
 */
public class MiddleOfLinkedList {

    static class ListNode {
        int var;
        ListNode next;

        public ListNode(int var) {
            this.var = var;
            this.next = null;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode listNodeCounter = head;

        int counter = 0;
        while (listNodeCounter != null) {
            counter++;
            listNodeCounter = listNodeCounter.next;
        }

        int mid = (int) Math.ceil((double) counter/2);
        for (int i = mid; i < counter; i++) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode root;
        root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = new ListNode(7);
        // input = [1,2,3,4,5,6,7]
        MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();

        print(middleOfLinkedList.middleNode(root));

    }

    static void print(ListNode node) {
        String items = "[";
        while (node != null) {
            items += node.var;
            if (node.next != null) {
                items += ",";
            }
            node = node.next;
        }
        items += "]";
        System.out.println("From middle: " + items);
    }
}
