// Given head, the head of a linked list, determine if the linked list has a cycle in it.
// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // while(fast!= null) FAILS :- bcoz this does not check for fast.next
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Check if both pointers meet
            if(slow == fast) { 
                return true; // Cycle exist
            }
        }
        return false; // Cycle does not exist
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        // Link them: 1 -> 2 -> 3 -> 4
        head.next = second;
        second.next = third;
        third.next = fourth;

        // Uncomment the next line to create a cycle
        fourth.next = second;

        System.out.println(hasCycle(head));
    }
}