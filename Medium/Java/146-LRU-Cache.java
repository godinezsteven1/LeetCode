class LRUCache {

    /**


    update cache O(1)
    map look up, insert, removal is instant 

    space O(n) n = capacity
    
    constraints:
        get and put must run in constant time O(1)
        biggest capacity?
        smallest capacity?
        biggest/smallest key to expect 
        biggest/smallest value to expect. 
        how many calls will be madde total 
    
    naive: hash map 
        just a hash map implementation with a rank system 
        capacity : 5            1,2,3,4,5
        for i i->5 
            !containsKey(i)
                put(i,val)
            else 
            if first occupied and remove and place 
    
    optimal: 
    
        hashMap<Integer, val? > 
    
        track lru 
        track val 
        track mru 
    
        list of value where index 0 is lru and list.size() - 1 mru 
        lru <-[val2]---[val3]--...----[valk]-[val1]-> mru 
        list.remove(index at val 3)
        lru <-[val2]---[empty]--...----[valk]-[val1]-> mru 
                        <--- O(index at val 3 - list.size())
    
        
        DLL 
        LRUCache lRUCache = new LRUCache(3);
        lRUCache.put(4, 4);
        LinkNode {int val, int key, prev, next}
    
        or
    
        updating cache. we want to put it as mru 
    
        rlu and mru sentinel nodes 
    
    
                    1               2               3
        headLRU [LinkNode]<---->[LinkNode]<----->[LinkNode] tailMRU 
    
            1               2              3.     m     4              5
        [headLRU]<-->[LinkNode]<---->[LinkNode]<----->[LinkNode]<-[here]->[tailMRU] 
    
    to access lru it would be headLRU.next 
    to access mru it would be tailMRU.prev 
    
        update cache {
            remove
               update pointers of before and after 
    
                

            insertMRU 

               pointer update for tailMRU.prev 
        }
    
     */

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

    LinkNode headLRU;
    LinkNode tailMRU;
    int capacity;
    HashMap<Integer, LinkNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.headLRU = new LinkNode(0, 0);
        this.tailMRU = new LinkNode(0, 0);
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
        //update the value of the key if the key exists.
        if (map.containsKey(key)) { 
            LinkNode dummy = map.get(key);
            dummy.val = value;
            updateCache(dummy);
            return; 
        }
        //If the number of keys exceeds the capacity from this operation, evict the least recently used key.
        if (map.size() == capacity) {
            LinkNode lru = headLRU.next; 
            map.remove(lru.key);
            remove(lru);
        }
        // add the key-value pair to the cache.
        LinkNode dummy = new LinkNode(key, value);
        map.put(key, dummy);
        insertMRU(dummy);
    }

    private void remove(LinkNode dummy) { // 2 
        //             1               2               3
        // headLRU [LinkNode]<--------->[LinkNode] tailMRU 
        // remove (2)
        dummy.prev.next = dummy.next; 
        dummy.next.prev = dummy.prev;
    }

    private void insertMRU(LinkNode dummy) {
        //                      2               
        // headLRU <..> <--->[LinkNode] <----> [tailMRU]
        //                           ^->[dummy1]<^
        // insertMRU (dummy1)
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