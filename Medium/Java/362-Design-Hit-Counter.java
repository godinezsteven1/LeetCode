class HitCounter {

    private Queue<Integer> q;
    private int maxAge;

    public HitCounter() {
        this.q = new LinkedList<>();
        this.maxAge = 300;
    }
    
    public void hit(int timestamp) {
        q.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        
        while (!q.isEmpty() && timestamp - q.peek() >= maxAge) {
            q.poll(); 
        }
        return q.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getq(timestamp);
 */