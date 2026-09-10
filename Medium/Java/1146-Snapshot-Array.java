class SnapshotArray {

    private ArrayList<Pair>[] history;
    private int snapID;
    private int length;

    private class Pair {
        private int pastSnapID; 
        private int val;
        Pair(int pastSnapID, int val) {
            this.pastSnapID = pastSnapID;
            this.val = val;
        }
    }

    public SnapshotArray(int length) {
        this.history = new ArrayList[length];
        this.snapID = 0;
        this.length = length;

        for(int i = 0; i < length; i++) {
            history[i] = new ArrayList<>();
        }
    }
    
    public void set(int index, int val) {
        history[index].add(new Pair(snapID, val));
    }
    
    public int snap() {
        return snapID++;
        
    }
    
    public int get(int index, int snap_id) {
        ArrayList<Pair> list = history[index];
        // binary search now 
        int left = 0;
        int right = list.size() - 1; 
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Pair curr = list.get(mid);
            if (curr.pastSnapID <= snap_id) {
                answer = curr.val;
                left = mid + 1;
            } else 
            if (curr.pastSnapID >= snap_id) {
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