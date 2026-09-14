class SnapshotArray {
    ArrayList<Pair>[] history;
    int length;
    int snapID;

    private class Pair {
        int val;
        int pastSnapID;
        Pair(int val, int pastSnapID) {
            this.val = val;
            this.pastSnapID = pastSnapID;
        }
    }

    // constraints? 
    /**
    naive 
    [1,2,3,4, 50,000]
    O(snap * n)
    set(1, 12)
    [12,2,3,4]
    snap = [12,2,3,4]

    // optimal 
    Pair(snap, 12)

    [ ,   ,  ,  , ]
    ()
    
    */
    

    // initializes an array-like data structure with the given length. Initially, each element equals 0.
    public SnapshotArray(int length) {
        this.history = new ArrayList[length];
        this.length = length;
        this.snapID = 0;

        for (int i = 0; i < length; i++) {
            history[i] = new ArrayList<>();
        }
    }
    
    // sets the element at the given index to be equal to val
    public void set(int index, int val) {
        history[index].add(new Pair(val, snapID)); 
    }
    
    // takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
    public int snap() {
        return snapID++;
    }
    
    // returns the value at the given index, at the time we took the snapshot with the given snap_id
    public int get(int index, int snap_id) {
        // bs 
        int left = 0;
        ArrayList<Pair> list = history[index];
        int right = list.size() - 1;
        int answer = 0;
        

        while (left <= right) {
            // history[index] = arrayList of history of given index
            // .get middle 
            int middle =  (left + right) / 2; 
            Pair curr = list.get(middle);
            if (snap_id < curr.pastSnapID) {
                // 10 <= 15
                right = middle - 1;
            }
                // 12 > 9
            if (snap_id >= curr.pastSnapID) {
                answer = curr.val;
                left = middle + 1;
            }
        }
        return answer;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */