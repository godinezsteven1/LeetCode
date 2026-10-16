class SnapshotArray {

    /**
        constraints: 
            array always be fixed length? 
            length?
            will index always be in length?
            how many times will snap ID be called 
            how many calls total. 
        naive; 
            map(snapID, history) curr 
            map(snapID, history) already snapped 
            0 -> 0,0,0,00,0
            0 -> 1, 0,0,0,0 

            history [1, 2,..., 50,000 ]
            set(0,0)
            history [0, 2,..., 50,000 ] 
            snap 
            history [0, 2,..., 50,000 ]  copy is going to be O(n * calls)
        optimal 

        ArrayList<Pair>[lenght] history
        
        Pair {
            int pastSnapID;
            int val;
            Pair(int pastSnapID, int val) {
                this.pastSnapID = pastSnapID;
                this.val = val;
            }
        }

        set(0,10) at snapID 20

        history.get(0).add(new Pair(20, 10)) / ordered (our snap ID)

        get we can do a rightmost bs 
        SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
        snapshotArr.set(0,1);  // Set array[0] = 5
        snapshotArr.snap();  // Take a snapshot, return snap_id = 0
        snapshotArr.set(0,5);  // Set array[0] = 5
        snapshotArr.snap();  // Take a snapshot, return snap_id = 0
        snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
    */

    private class Pair {
        int pastSnapID;
        int val;
        Pair(int pastSnapID, int val) {
            this.pastSnapID = pastSnapID;
            this.val = val;
        }
    }

    ArrayList<Pair>[] history;
    int snapID;
    int length;

    public SnapshotArray(int length) {
        this.length = length;
        this.snapID = 0;
        this.history = new ArrayList[length];

        for(int i = 0; i < history.length; i++) {
            history[i] = new ArrayList<Pair>();
        }
    }
    
    public void set(int index, int val) {
        history[index].add(new Pair(snapID, val));
    }
    
    public int snap() {
        return snapID++;
    }
    
    public int get(int index, int snap_id) {
        int left = 0; 
        ArrayList<Pair> list = history[index];
        int right = list.size() - 1;
        int answer = 0; 

        while (left <= right) {
            int mid = (right + left) / 2;
            Pair curr = list.get(mid);
            if (curr.pastSnapID <= snap_id) {
                // 5 <= 10 
                answer = curr.val;
                left = mid + 1;
            }
            if (curr.pastSnapID > snap_id) {
                // 5 >= 2
                right = mid - 1;
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