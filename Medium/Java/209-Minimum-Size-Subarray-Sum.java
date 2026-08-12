class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE; // set as unsolved 

        for (int right = 0; right < nums.length; right++) {
            // for every int going to the right
            // add to current sum 
            sum += nums[right];
            
            // when current sum >= target, get the min of those values.
            while (sum >= target) {
                min = Math.min(min, right - left + 1); // size of window 
                sum -= nums[left++]; // shorten the window 
            }
        }

        if (min == Integer.MAX_VALUE) { // check if that value is still unsolved. 
            return 0;
        }

        return min;
    }
}