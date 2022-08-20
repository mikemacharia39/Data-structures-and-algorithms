package javasolutionsforalgorithms.leettests.advanceddatastructures;

/**
 * Given head which is a reference node to a singly-linked list.
 * The value of each node in the linked list is either 0 or 1.
 * The linked list holds the binary representation of a number.
 * <p>
 * Return the decimal value of the number in the linked list.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * <p>
 * Example 2:
 * <p>
 * Input: head = [0]
 * Output: 0
 */
public class ConvertBinaryNumberInLinkedListToInteger {

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public int getDecimalValue(ListNode head) {

        int sum = 0;

        while (head != null) {
            sum = (2 * sum) + head.val;

            head = head.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode root;
        root = new ListNode(1);
        root.next = new ListNode(0);
        root.next.next = new ListNode(1);

        ConvertBinaryNumberInLinkedListToInteger toInteger = new ConvertBinaryNumberInLinkedListToInteger();

        System.out.println("Integer Value: " + toInteger.getDecimalValue(root));
    }
}
