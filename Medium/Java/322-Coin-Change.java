class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 0; // cant make 0 with 0
        
        for(int n = 1; n <= amount; n++) {
            dp[n] = amount + 1; // havent found sol
        }

        for(int n = 1; n <= amount; n++) {
            for(int coin: coins) {
                if (coin <= n) {
                    dp[n] = Math.min(dp[n], dp[n - coin] + 1);
                }
            }
        }

        if (dp[amount] == amount + 1) {
            return -1;
        }
        return dp[amount];

    }
}