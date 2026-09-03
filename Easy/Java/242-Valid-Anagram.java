class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char l: s.toCharArray()) {
            map.put(l, map.getOrDefault(l,0) + 1);
        }
        for (char l: t.toCharArray()) {
            if (!map.containsKey(l)) {
                return false;
            }
            map.replace(l, map.get(l) - 1);
            if (map.get(l) == 0) {
                map.remove(l);
            }
        }
        return map.isEmpty();
    }
}