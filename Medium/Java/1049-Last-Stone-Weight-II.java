class Solution {
    public int lastStoneWeightII(int[] stones) {
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