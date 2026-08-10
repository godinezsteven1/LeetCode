class Solution {
    public int lengthOfLIS(int[] nums) {
        
        // base cases:
        // empty
        if (nums.length == 0) {
            return 0;
        }
        // 1 element 
        if (nums.length == 1) {
            return 1;
        }
        // all elements the same

        // init table
        int[] dp = new int[nums.length];
        // current LIS
        int lengthLIS = 1;

        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        for(int i = 0; i < nums.length; i++) {

            for(int j = 0; j < i; j++) {
                // transition here 
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                if (dp[i] > lengthLIS) {
                    lengthLIS = dp[i];
                }
            }
        }
        return lengthLIS;
    }
}