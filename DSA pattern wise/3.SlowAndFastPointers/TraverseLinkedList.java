class Node {
    int val;
    Node next;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node next) { this.val = val; this.next = next; }
}

public class TraverseLinkedList {
    public static void traverseList(Node head) {
        Node temp = head; // we create a local temp variable to get head value because head should always point to the first node. If you use head for traversal, you'll lose the starting point of the linked list.

        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        // create a LL as : 1 - 2 - 3 - 4 - 5
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = null;

        traverseList(head);
        traverseList(three); // 3 4 5
    }
}
