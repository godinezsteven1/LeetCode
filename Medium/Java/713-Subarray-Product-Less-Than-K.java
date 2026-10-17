class Solution {
    /**
    constraints:
        k > 1, no 
        nums ever be empty? 
        largest k value we can expect 
        largest nums[i] to expext 
        smallest nums[i] to expect; 
        biggest length for nums.length; 

    naive: 
        Input: nums = [10,5,2,6], k = 100

        brute force 
        for i
            for j
                if i * j < k {add this to answer }
    
    optimal: 
        sliding window 

        number we add to product and we check aginst k . add counter 


        Input: nums = [10,5,2,6], k = 100

        product: 60 =  5 * 2 * 6
        right = 3
        left = 1 
        count = 8;

        int left = 0; 
        int product = 1;
        int count = 0;

        for(int right = 0; right < nums.length; right++) {
            product *= nums[right]; 
            while (product >= k) {
                product /= nums[left];
                left++
            }
            count += right - left + 1;
        }

        return count; 
    
    
    
    
    
    */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2) {
            return 0; 
        }
        int left = 0; 
        int product = 1;
        int count = 0;

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