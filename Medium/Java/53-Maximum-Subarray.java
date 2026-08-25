import java.util.Arrays;

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0]; // max so far 

        int maxEnding = nums[0]; // max sum ending at current posn

        for (int i = 1; i < nums.length; i++) {
            // either take or not
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            // update max
            max = Math.max(max, maxEnding);
        }
        return max;
    }
}