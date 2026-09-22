class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase(); 
        int right = s.length() - 1;
        int middle = right / 2; 
        for(int left = 0; left < right; left++) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            right--;
        }
        return true;
        /**
        constraints: 
            upper case; 
            numbers 
        naive: 
            cumbersome approach to constraints 

        optimal :

        two pointers coming from left to right and just charAt their index; 
        remove upper case and non alpanumeric characters 
        */
    }
}