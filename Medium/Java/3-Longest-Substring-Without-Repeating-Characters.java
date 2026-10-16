class Solution {
    /**
    constraints: 
        english letter string 
        longest string i can expect? 
        shortest string i can expect? 
        non empty string or do i check for that instance. 
    
    naive: 
        brute force approach where at the current letter we are going to check forward and see if those violate our LSWRC rules. running max 
    
    optimal: 
        sliding window 
    
        int left = 0;
        int max = 0;
    
    
        HashSet<Character> seen = new HashSet<>();
        for(int right = 0; right < s.length(); right++) {
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            max = Math.max(max, right - left + 1); // 3
        }
    
    
    
    
    */
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;

        HashSet<Character> seen = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            max = Math.max(max, right - left + 1); 
        }
        return max; 
    }
}