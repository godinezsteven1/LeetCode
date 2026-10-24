class Solution {

    /**
    constraints: 
        smallest k value we will be given? k = 1,  k < 1 
        largest and smallset lenghth of nums; 
        largest and smallest value in nums (negative, large values)
        largest k value given 
        nums = [10,5,2,6] could i do [10,6] subarray connected horizontally 

    naive: 
        brute force  O(n^2)
        for i 
            for j
                if nums[i] * nums[j] < k 
                    counter 
    
    optimal:    
        sliding window 
        
        every time we are under product k we can keep expanding and moving and we violate we 
        remove leftmost number and continue 


        if (k < 1) {
        return 0;
        }
        int left = 0;
        int product = 1; 
        int counter = 0;
        // [10,5,2,6]
        ____

        left = 
        product = 5 * 2 * 6 = 60
        counter = 6 (10,5,2,10*5, 10*2, 5*2)
        right = 

        ____
        // k = 100 
        for(int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            count += right - left + 1;
        }

     */


    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2) {
            return 0; 
        }

        int left = 0;
        int counter = 0;
        int product = 1; 

        for(int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            counter += right - left + 1;
        }

        return counter;
    }
}