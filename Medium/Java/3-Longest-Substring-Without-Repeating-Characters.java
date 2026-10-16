class Solution {

    /**
    constraints: 
        s will be non empty 
        s will be english characters, digits symbol and spaces do i remove? 
        how long will s b? 

    naive: 
        brute force that goes if i am at a does a come after, or after that and so on and have a running max like that. 

    optimal: // "abcab"
        sliding window approach 
        int left = 0;
        int max = 0; 

        HashSet<Characters> seen = new HashSet<>();
        for(int right = 0; right < s.length() - 1; right++) {
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right)); // seen: ca
            max = Math.max(max, right - left + 1);
        }

        return max; 
    
    
    
    
    
    */
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0; 

        HashSet<Character> seen = new HashSet<>();
        for(int right = 0; right < s.length(); right++) {
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