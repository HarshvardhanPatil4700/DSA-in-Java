class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class MiddleOfLinkedList {
    public static ListNode middleNode(ListNode head) {
        // Slow and fast pointers - TC = O(n), SC = O(1)
        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        // Linked list => 1 -> 2 -> 3 -> 4 -> 5
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        System.out.println(middleNode(head).val);
    }
}