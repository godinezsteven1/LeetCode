class LRUCache {


    HashMap<Integer, LinkNode> map;
    int capacity;
    int key;
    LinkNode headLRU;
    LinkNode tailMRU;


    private class LinkNode {
        int key;
        int val;
        LinkNode prev;
        LinkNode next;
        LinkNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
    hash map

    naive: 
    hash map 
    <integer, Pair(rank, val)> 


    need pointer lru <lru---mru>
    DLL head tail
    headLRU 
    tailMRU

    [headLRU]<->[real lru]<->[dummy]<->[real mru]<->[tailMRU]

    ...<->[real mru]<->[tailMRU]
                  [dummy]
    
     */

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.key = key;
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
        }
        if (map.size() == capacity) {
            LinkNode lru = headLRU.next;
            map.remove(lru.key);
            remove(lru);
        } 
        LinkNode dummy = new LinkNode(key, value);
        map.put(key, dummy);
        insertMRU(dummy);
    }

    private void remove(LinkNode dummy) {
        //[headLRU]<->[real lru]<->[dummy]<->[real mru]<->[tailMRU]
        dummy.prev.next = dummy.next;
        dummy.next.prev = dummy.prev;
    }

    private void insertMRU(LinkNode dummy) {
        //    ...<->[real mru]<->[tailMRU]
        //               ^ >[dummy]< ^
        tailMRU.prev.next = dummy;
        dummy.prev = tailMRU.prev;
        tailMRU.prev = dummy;
        dummy.next = tailMRU;
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