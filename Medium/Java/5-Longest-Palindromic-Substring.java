class Solution {

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int start = 0;
        int substring = 0;
        for(int i = 0; i < s.length(); i++) {
            int len1 = expandAround(s, i, i);
            int len2 = expandAround(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > substring) {
                start = i - (len - 1) / 2;
                substring = len;
            }
        }
        return s.substring(start, start + substring);
        
    }

    private int expandAround(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}