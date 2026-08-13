class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;

        // sliding window 
        HashSet<Character> curr = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {

            while (curr.contains(s.charAt(right))) {
                curr.remove(s.charAt(left));
                left++;
            }

            curr.add(s.charAt(right));

            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}