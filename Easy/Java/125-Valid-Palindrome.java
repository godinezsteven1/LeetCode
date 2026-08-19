class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        int right = s.length() - 1;
        int mid = s.length() / 2; 

        for(int left = 0; left < mid; left++) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            right--;
        }
        return true;
    }
}