class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertingElementInLinkedList {
    Node head;   // Class variable
    public void insertAtStart(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtAnyPosition(int val,int pos) {
        Node temp = head;
        Node newNode = new Node(val);
        if(pos == 1) {
            insertAtStart(val);
            return;
        }
        for(int i=1;i<pos-1;i++) {
            temp  = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void insertAtEnd(int val) {
        Node newNode = new Node(val);
        if(head == null) { // empty list
            head = newNode;
            return;
        }
        
        Node temp = head;
        while(temp.next!=null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        InsertingElementInLinkedList list = new InsertingElementInLinkedList();
        list.head = new Node(10);
        list.head.next = new Node(20);
        list.head.next.next = new Node(30);

        // Insert at Start position :
        System.out.print("Before : ");
        list.printList();
        list.insertAtStart(5);
        System.out.print("After : ");
        list.printList();
        System.out.println();

        // Insert at any position :
        InsertingElementInLinkedList li = new InsertingElementInLinkedList();
        li.head = new Node(10);
        li.head.next = new Node(20);
        li.head.next.next = new Node(40);
        li.head.next.next.next = new Node(50);
        System.out.print("Before : ");
        li.printList();
        li.insertAtAnyPosition(30, 3);
        System.out.print("After : ");
        li.printList();
        System.out.println();

        // 
        InsertingElementInLinkedList l = new InsertingElementInLinkedList();
        l.head = new Node(10);
        l.head.next = new Node(20);
        l.head.next.next = new Node(30);
        l.head.next.next.next = new Node(40);
        System.out.print("Before : ");
        l.printList();
        l.insertAtEnd(50);
        System.out.print("After : ");
        l.printList();
        System.out.println();
    }
}