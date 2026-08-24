class LRUCache {

    private HashMap<Integer, LinkNode> hashMap;
    private int capacity;

    private LinkNode headLRU; 
    private LinkNode tailMRU; 

    private class LinkNode {

        private LinkNode prev; 
        private LinkNode next;
        private int key; 
        private int val;

        private LinkNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.hashMap = new HashMap<>(capacity);
        this.headLRU = new LinkNode(0,0);
        this.tailMRU = new LinkNode(0,0);
        headLRU.next = tailMRU;
        tailMRU.prev = headLRU;
    }
    
    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }
        LinkNode dummy = hashMap.get(key);
        remove(dummy);
        insertMRU(dummy);
        return dummy.val;
    }
    
    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            LinkNode dummy = hashMap.get(key);
            dummy.val = value;
            remove(dummy);
            insertMRU(dummy);
            return;
        } else
        if (hashMap.size() == capacity) {
            LinkNode lru = headLRU.next;
            remove(headLRU.next); 
            hashMap.remove(lru.key);
        }
        LinkNode dummy = new LinkNode(key, value);
        insertMRU(dummy);
        hashMap.put(key, dummy);
    }

    private void insertMRU(LinkNode dummy) {
        tailMRU.prev.next = dummy; 
        dummy.prev = tailMRU.prev;
        dummy.next = tailMRU;
        tailMRU.prev = dummy;
    }

    private void remove(LinkNode dummy) {
        dummy.prev.next = dummy.next;
        dummy.next.prev = dummy.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */