class Solution {
    public int rob(int[] nums) {

        if (nums.length < 2) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        // memoization pattern
        
        // set base case
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // now we have our first case of n-2 and n-1 

        for(int n = 2; n < dp.length; n++) {
            dp[n] = Math.max(dp[n - 2] + nums[n], dp[n - 1]);
        }

        return dp[nums.length - 1];
        
    }
}