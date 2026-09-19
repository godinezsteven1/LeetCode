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

    public SnapshotArray(int length) {
        this.length = length;
        this.history = new ArrayList[length];
        this.snapID = 0;

        for(int i = 0; i < length; i++) {
            history[i] = new ArrayList<>();
        }
    }
    
    public void set(int index, int val) {
        history[index].add(new Pair(val, snapID));
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
            int mid = (left + right) / 2;
            Pair curr = list.get(mid);
            if (curr.pastSnapID <= snap_id) {
                left = mid + 1;
                answer = curr.val;
            }
            if (curr.pastSnapID > snap_id) {
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