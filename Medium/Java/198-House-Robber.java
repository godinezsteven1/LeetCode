class Solution {
    public int rob(int[] nums) {
        // base cases
        if (nums.length == 0) { 
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // init table
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        
        for(int n = 2; n < nums.length; n++) {
            // transition state
            dp[n] = Math.max(
                dp[n - 1], // skip n 
                dp[n - 2] + nums[n]); // take n 
        }
        return dp[nums.length - 1];
    }
}