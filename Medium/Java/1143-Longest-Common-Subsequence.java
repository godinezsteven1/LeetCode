class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /**
        base cases: one of them is empty, both empty, null, equal to one another 
        constraints: only letters, blah balh balh 

        naive: 
            add one of the text to hashset 
            if (!hashset.add(charoftext1)) {
               counter++ }
            brute force 
            +1 +1. +1
            a. c.  e
            a. c.  e 
                         5
              t e x t 2
            t -  > right = dp[i][j + 1]
            e.   v down = dp[i + 1][j]
            x.  
            t
            1
            dp[i][j] = 1 + dp[i + 1][j + 1]
         */
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }
}