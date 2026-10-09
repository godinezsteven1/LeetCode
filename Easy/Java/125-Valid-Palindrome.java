class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        int left = 0;
        for (int right = s.length() - 1; right >= left; right--) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
        }
        return true;
    }
}