package leettests;

/**
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has
 * Node.val == val, and return the new head.
 *
 * Example 1:
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 *
 * Example 2:
 * Input: head = [], val = 1
 * Output: []
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {

        RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int valToRemove = 4;

        removeLinkedListElements.removeElements(head, valToRemove);
    }

    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode current = head;

        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}
