class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");
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