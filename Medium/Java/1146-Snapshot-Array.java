class SnapshotArray {

    private class Pair {
        int pastSnapID;
        int val; 
        Pair(int pastSnapID, int val) {
            this.pastSnapID = pastSnapID;
            this.val = val;
        }
    }

    ArrayList[] history;
    int snapID;

    public SnapshotArray(int length) {
        this.history = new ArrayList[length];
        this.snapID = 0;

        for(int i = 0; i < length; i++) {
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
        ArrayList<Pair> list = history[index];
        int left = 0;
        int right = list.size() - 1;
        int answer = 0;

        while (left <= right) {
            int middle = (left + right) / 2;
            Pair curr = list.get(middle);
            if (curr.pastSnapID <= snap_id) {
                left = middle + 1;
                answer = curr.val;
            }
            if (curr.pastSnapID > snap_id) {
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