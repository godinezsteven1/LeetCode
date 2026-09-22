class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**

        constraints:   
            english letters symbols and spaces 
        
        naive : 
            brute force 
                at each letter we are comparing does next word = previous?, if not does next word = last 2 previous
                and so on

        optimal: 
            some sort of sliding window 
            condition: hash set  does not allow duplicates 
            so our window moving condition has to do with add in hashset 
        */

        HashSet<Character> set = new HashSet<>();
        int max = 0; // or set.size()
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1); // [left 0 right , 0, ]
        }


        return max;
    }
}