class SnapshotArray {

    private class Pair {
        int pastSnapID;
        int val;

        Pair(int pastSnapID, int val) {
            this.pastSnapID = pastSnapID;
            this.val = val;
        }
    }

    ArrayList<Pair>[] history;
    int maxAge;
    int snapID;
    int length;

    public SnapshotArray(int length) {
        this.length = length;
        this.maxAge = 300;
        this.snapID = 0;
        this.history = new ArrayList[length];

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
        int left = 0; 
        ArrayList<Pair> list = history[index];
        int right = list.size() - 1;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            Pair curr = list.get(mid);
            if (curr.pastSnapID <= snap_id) {
                answer = curr.val;
                left = mid + 1;
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