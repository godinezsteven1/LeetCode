class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>(); 

        for(int i = 0; i < strs.length; i++) {
            String curr = strs[i];
            char[] c = curr.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(curr);
        }

        return new ArrayList<>(map.values());
    }
}