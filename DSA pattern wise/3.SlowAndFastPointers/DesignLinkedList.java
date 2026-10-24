class DesignLinkedList {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode dummy;
    private int size;

    public DesignLinkedList() {
        dummy = new ListNode(0);
        size = 0;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size) {
            return -1;
        }
        
        ListNode current = dummy.next;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            index = 0;
        }

        if (index > size) {
            return;
        }

        ListNode current = dummy;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        ListNode newNode = new ListNode(val);

        newNode.next = current.next;
        current.next = newNode;

        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        ListNode current = dummy;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.next = current.next.next;

        size--;
    }
    public static void main(String[] args) {
        DesignLinkedList obj = new DesignLinkedList();

        obj.addAtHead(1);      // [1]
        obj.deleteAtIndex(0);  // []
        obj.addAtTail(2);      // [2]
        int result = obj.get(0);

        System.out.println(result); // Output: 2
    }        
}