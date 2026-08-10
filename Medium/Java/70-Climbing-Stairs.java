class Solution {
    public int climbStairs(int n) {
        // base cases 
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1; 
        }
        if (n == 2) {
            return 2;
        }
        // init table
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
 
        for(int i = 2; i < n; i++) {
            // transition period 
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}