class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k < 2) {
            return 0;
        }

        /**
        
        constraints:
            k biggest and smallest k to expect 
            biggest and smallest nums.length to expect 
            biggest and smalles nums[i] to expect 
         */

        int product = 1;
        int count = 0; 
        int left = 0;

        for(int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            count += right - left + 1;
        }

        return count;
    }
}