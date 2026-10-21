class Solution {
    /**
    constraints : 
        we can have numbers, upper acse, special characters 
        input is diverse we need to clean input
        longest string we can expect? 
        s can be empty.  

    naive: 
        s = s.lowerCase;
        s = s.replace("regex", ""); 
        hash set and will add half it (s.size() - 1)
        the other half was to fail to add it 
        // extra ds 

    optimal; 
        s = s.lowerCase;
        s = s.replace("regex", ""); 
        int left = 0;

        for(int right = s.length() - 1; right >= left; right--) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }

        return true; 
    
    
    
    
    
    */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", ""); // O(n) time 
        int left = 0;
        for(int right = s.length() - 1; right >= left; right--) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
        }

        return true; 
    }
}