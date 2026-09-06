class Solution {
    public String longestCommonPrefix(String[] strs) {
        String answer = "";
        String first = strs[0];
        for(int i = 0; i < first.length(); i++) {
            char curr = first.charAt(i);
            for(int n = 1; n < strs.length; n++) {
                if (i >= strs[n].length()) {
                return answer;
                }
                char curr2 = strs[n].charAt(i);
                if (curr2 != curr) {
                    return answer;
                }
            }
            answer += curr;
        }
        return answer;
    }
}