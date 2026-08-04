
// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
// Do not modify the linked list.

class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }
    
}
public class StartOfLinkedListCycle {
    public static ListNode startOfCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Step 1 : Detect if cycle exist
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;

            // Step 2 : Find the start of cycle
            if(slow == fast) { // Meeting point
                slow = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;

        System.out.println(startOfCycle(head).val);
    }
}
