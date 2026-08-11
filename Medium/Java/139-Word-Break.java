class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // length 0: "" 

        for(int j = 1; j <= s.length(); j++) {
            for(int i = 0; i < j; i++) {
                if (dp[i] && wordDict.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }

        return dp[s.length()];
    }
}