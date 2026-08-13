import java.util.HashMap;

class LRUCache {

    private int capacity;
    private HashMap<Integer, Node> cache;

    private Node left;
    private Node right; 

    private class Node{

        private int key;
        private int value;
        private Node prev; 
        private Node next;


        Node(int key, int value) {
            this.key = key;
            this.value = value; 
        }
    }

    /**
     * init LRU cache w Pos capacity
     * Essentially behaving as constructor 
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<Integer, Node>();

        // doubly LL 
        this.left = new Node(0,0);
        this.right = new Node(0,0);

        left.next = right;
        right.prev = left; 
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
    }

    private void insert(Node node) {
        Node prev = right.prev;

        prev.next = node;
        node.prev = prev;

        node.next = right;
        right.prev = node;
    }
    
    /**
     * Returns val of key, return -1 if no exist
     */
    public int get(int key) {
        if (cache.get(key) == null) {
            return -1; // key not found or.. maps to null 
        }
        Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.value;
    }
    
    /**
     * update val of key --> value if it exist.

     * otherwise, add | Key | Value |to cache. 

     * if # of keys exceeds capacity, evict LRU key.
     */
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value; // update said value 

            remove(node);
            insert(node);
        }
        if (!cache.containsKey(key)) {
            Node node = new Node(key, value);
            cache.put(key, node);
            insert(node);
            if (cache.size() > capacity) {
                Node lru = left.next;
                cache.remove(lru.key);
                remove(lru);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */