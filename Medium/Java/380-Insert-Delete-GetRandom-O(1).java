class RandomizedSet {


    HashMap<Integer, Integer> map; // key our #, val -> idx in array list so we can do a O(1) removal 
    ArrayList<Integer> list;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int removeIdx = map.get(val);
        int lastValue = list.get(list.size() - 1); 
        list.set(removeIdx, lastValue);
        map.put(lastValue, removeIdx);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        int randomInt = random.nextInt(list.size());
        return list.get(randomInt);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */