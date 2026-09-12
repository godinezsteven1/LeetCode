class Solution {
    public int lastStoneWeightII(int[] stones) {


        /**
        
        sum stones = 23  int java / 2
                    /  \
                   11.  12 = 1
                   23 - 22 = 1
        
        stones sum 
        int target
        dp[target]

        for stone in stones 
            for i = target; i >= stone; i--
                dp[i] = max(dp[i], dp[i - stone] + stone)
         */
        
        // return 2 * dp[target]

        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        int[] dp = new int[target + 1];

        for(int stone: stones) {
            for (int i = target; i >= stone; i--) {
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }
        return sum - 2 * dp[target];
    }
}