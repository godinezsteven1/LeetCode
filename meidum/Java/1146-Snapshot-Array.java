class SnapshotArray {

    /**
    
    naive: 
        array = [, , , ,]
        set(0,5) = [5, , , ]
        snap // return 0 snap makes a copy of this array [5, , , ]
        set(1,6) = [6, , , ]
        snap // 1 snap makes a copy of this array [6, , , ] 

        issue: our memory / space complexity O(n * snap) assuming 1 change per snap 
    optimal:                Pair(pastSnapID, val)
        ArrayList[] history = [ [(0, 5), (1,6) ... (k, n) (,)], [], [], [] ]
        history of change = current snap, value changed to 
    
    SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
    snapshotArr.set(0,5);  // Set array[0] = 5
    snapshotArr.snap();  // Take a snapshot, return snap_id = 0
    snapshotArr.set(0,6);
    snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
        history[i] 
    binary search get returns in log n 
    
    */

    private class Pair {
        int pastSnapID; 
        int val; 
        Pair(int pastSnapID, int val) {
            this.pastSnapID = pastSnapID;
            this.val = val;
        }
    }

    private ArrayList<Pair>[] history;
    private int length;
    private int snapID;


    public SnapshotArray(int length) {
        this.length = length;
        this.history = new ArrayList[length];
        this.snapID = 0;

        for (int i = 0; i < length; i++) { // time complexity O(n) space O(i * length of the ith list)
            history[i] = new ArrayList<>();
        }
    }
    
    public void set(int index, int val) {
        // access index 
        // grab snap id 
        // create a new pair value that we will add at that indxe 
        history[index].add(new Pair(snapID, val));
    }
    
    public int snap() {
        return snapID++; // left to right  return snapID then increment return ++snapID; 
    }
    
    public int get(int index, int snap_id) {
        //bs 
        ArrayList<Pair> list = history[index];
        int left = 0;
        int right = list.size() - 1;
        int answer = 0;
        
        while (left <= right) {
            int middle = (left + right) / 2;
            Pair curr = list.get(middle);
            if (curr.pastSnapID <= snap_id) {
                //       10 < 15 go right 
                left = middle + 1;
                answer = curr.val;
            }
            if (curr.pastSnapID > snap_id) {
                // 15 > 10 go left 
                right = middle - 1;
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