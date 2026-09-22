class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /**
        
        constraints:
            return length not the actual subsequence
            can b none
            all lowercase english characters 
            duplicates?
        
        naive: brute force
            text1 = "abcde", text2 = "ace" 
                text1 i have an 'a' does text 2 have an 'a'? 
                text1 i have a 'b' does text 2 have a 'b'?
                ...
                return counter


        optimal: 
            Input: text1 = "abcde", text2 = "ace" 
            Output: 3  
            second: b vs c
            for loops we want to go backwards 
            dp[i][j] = {
               t. c. x. t. 2
            t   
            b     x -> j + 1
            x.    v (i + 1)
            t
            1             x
             00 0 0 0 0 0 0 00 
            if text1.charAt(i) == text2.charAt(j) {
                dp[i][j] = 1 + dp[i + 1][j + 1]
            }
            dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j])

            }

            return dp[0][0]
        
        */

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        // abcdef length 6 +   abc = 3 +  = 3
        // dp of size 6 x 3
        // i = 4 -> 0 
        // j = 2 
        for(int i = text1.length() - 1; i >= 0; i--) {
            for(int j = text2.length() - 1; j >= 0; j--) {
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