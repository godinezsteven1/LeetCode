class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false; 
        }
        HashMap<Character, Integer> hashMapS = new HashMap<>();
        HashMap<Character, Integer> hashMapT = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            hashMapS.put(charS, hashMapS.getOrDefault(charS, 0) + 1);
            hashMapT.put(charT, hashMapT.getOrDefault(charT, 0) + 1);
        }
        return hashMapS.equals(hashMapT);
    }
}