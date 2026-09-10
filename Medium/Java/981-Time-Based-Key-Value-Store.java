class TimeMap {

    private Map<String, TreeMap<Integer, String>> treeMap;

    public TimeMap() {
        treeMap = new HashMap<>();        
    }
    
    public void set(String key, String value, int timestamp) {
        treeMap.putIfAbsent(key, new TreeMap<>());
        treeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!treeMap.containsKey(key)) {
            return "";
        }
        Integer floorKey = treeMap.get(key).floorKey(timestamp); 
        if (floorKey == null) {
            return "";
        }
        return treeMap.get(key).get(floorKey);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */