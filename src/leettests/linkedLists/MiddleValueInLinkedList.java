package leettests.linkedLists;

public class MiddleValueInLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public int middleValueInLinkedList(ListNode root) {
        if (root == null) {
            return 0;
        }

        ListNode counterNode = root;

        int counter = 0;
        while (counterNode != null) {
            counter++;
            counterNode = counterNode.next;
        }

        int mid = (int) Math.ceil((double) counter/2);

        for (int i = mid; i < counter; i++) {
            root = root.next;
        }

        return root.val;
    }

    public static void main(String[] args) {
        MiddleValueInLinkedList middleValueInLinkedList = new MiddleValueInLinkedList();

        ListNode root;
        root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = new ListNode(7);

        ListNode printed = root;
        print(printed);

        System.out.println("Middle: " + middleValueInLinkedList.middleValueInLinkedList(root));
    }

    static void print(ListNode node) {
        String items = "[";
        while (node != null) {
            items += node.val;
            if (node.next != null) {
                items += ",";
            }
            node = node.next;
        }
        items += "]";
        System.out.println("Items: " + items);
    }
}
