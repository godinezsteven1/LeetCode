class LRUCache {

    private int capacity;
    private HashMap<Integer, LinkNode> map;
    private LinkNode headLRU;
    private LinkNode tailMRU;

    private class LinkNode {
        LinkNode prev; 
        LinkNode next;
        int key;
        int val;

        LinkNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.headLRU = new LinkNode(0,0);
        this.tailMRU = new LinkNode(0,0);
        headLRU.next = tailMRU;
        tailMRU.prev = headLRU;
    }
    


    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        LinkNode dummy = map.get(key);
        updateCache(dummy);
        return dummy.val;
    }
    

    public void put(int key, int value) { 
        if (map.containsKey(key)) {
            LinkNode dummy = map.get(key);
            dummy.val = value;
            updateCache(dummy);
            return;
        } else
        if (map.size() == capacity) {
            LinkNode lru = headLRU.next; 
            remove(lru);
            map.remove(lru.key);
        }
        LinkNode dummy = new LinkNode(key, value);
        insertMRU(dummy);
        map.put(key, dummy);
    }

    private void remove(LinkNode dummy) {
        dummy.prev.next = dummy.next;
        dummy.next.prev = dummy.prev;

    }

    private void insertMRU(LinkNode dummy) {
        tailMRU.prev.next = dummy;
        dummy.prev = tailMRU.prev;
        dummy.next = tailMRU;
        tailMRU.prev = dummy;
    }

    private void updateCache(LinkNode dummy) {
        remove(dummy);
        insertMRU(dummy);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */