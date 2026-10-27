class HitCounter {


    /**
    constraints 
        will it always be 300 sec 
        negative hit number? 
        smallest and largest number well be given 
        biggest hit number given 
        how many times this class will be called. 
    naive: 
        index[n]
        put timestamp in hit order . 
    optimal: 
        int maxAge
        Queue<> q = new likedlist<>()

        hitcounter() {
            this.maxAge = 300; 
            this.q = new LL<>();
        }

        hit = q.add(timestamp)

        getHits                     301 - 300 >= 300 
            while(!q.isEmpty() && timestamp - q.peek() >= ) {
                q.poll();
            }
            return q.size(); 
    
    
    
    
    
     */


    Queue<Integer> q; 
    int maxAge; 

    public HitCounter() {
        this.maxAge = 300;
        this.q = new LinkedList<>();
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
 * int param_2 = obj.getHits(timestamp);
 */