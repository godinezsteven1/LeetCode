class Solution {
    public int lastStoneWeightII(int[] stones) {
        /**

        naive: 
            brute force of all possible combinations stones.length! 

        optimal: 
            dp[i] = dp[i], dp[i - stone] + stone
        dp[sum / 2 = target] 
        sum - 2 * dp[target]
        
        Input: stones = [2,7,4,1,8,1] = sum 23 / 2 = 12 and 11 = 1
         Output: 1

    
         */

        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        int[] dp = new int[target + 1];

        for(int stone: stones) {
            for(int i = target; i >= stone; i--) {
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }
        return sum - 2 * dp[target];
    }
}