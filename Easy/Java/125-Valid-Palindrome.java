class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        int left = 0;
        char[] word = s.toCharArray();
        
        for (int right = word.length - 1; right >= left; right--) {
            if (s.charAt(left) != s.charAt(right)) {
            return false;
            }
            left++;
        }
        return true;
    }
}