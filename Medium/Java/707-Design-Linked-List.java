class MyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int size; 

    /**
    Doubly link list Imp
     */
    private class ListNode {
        

        private ListNode prev;
        private int val;  
        private ListNode next; 

        private ListNode(int val) {
            this.val = val;
        }

        private ListNode(int val, ListNode prev, ListNode next) {
            this.prev = prev;
            this.val = val;
            this.next = next;
        }

    }

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    
    /**
    Get idx node, if idx invalid return -1 
     */
    public int get(int index) {
        ListNode node = head;
        if (index >= size || index < 0) {
            return -1;
        }

        for (int i = 0; i < index; i++) {
            if (node == null) {
                return -1;
            }
            node = node.next;
        }
        if (node == null) { return -1; }
        return node.val;
    }
    
    public void addAtHead(int val) {
        // base cases no head 
        if (head == null) {
            ListNode node = new ListNode(val);
            head = node;
            tail = node;
            size++;
            return;
        }
        ListNode newHead = new ListNode(val, null, head);
        head.prev = newHead;
        head = newHead;
        size++;
    }
    
    public void addAtTail(int val) {
        // base cases no tail 
        if (tail == null) {
            ListNode node = new ListNode(val); 
            head = node; 
            tail = node;
            size++;
            return; 
        }
        ListNode newTail = new ListNode(val, tail, null);
        tail.next = newTail;
        tail = newTail;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        // base cases 
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        } else
        if (index == size) {
            addAtTail(val);
            return;
        }
        ListNode node = new ListNode(val); 
        ListNode dummy = head;
        for (int i = 0; i < index; i++) {
            dummy = dummy.next;
        }
        node.prev = dummy.prev;
        node.next = dummy;
        dummy.prev.next = node;
        dummy.prev = node;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (size == 1) {
            tail = null;
            head = null;
            size--;
            return;
        }
        if (index == 0) {
            head = head.next;
            head.prev.next = null;
            head.prev = null;
            size--;
            return;
        }
        if (index == size - 1) {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
            size--;
            return;
        }
        ListNode dummy = head;
        for (int i = 0; i < index; i++) {
            dummy = dummy.next;
        }
        dummy.prev.next = dummy.next;
        dummy.next.prev = dummy.prev;
        dummy.prev = null;
        dummy.next = null;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */