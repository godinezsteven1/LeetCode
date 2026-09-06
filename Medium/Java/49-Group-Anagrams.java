class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String string: strs) {
            char[] charV = string.toCharArray();
            Arrays.sort(charV);
            String sorted = new String(charV);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(string);
        }
        return new ArrayList<>(map.values()); 
    }
}