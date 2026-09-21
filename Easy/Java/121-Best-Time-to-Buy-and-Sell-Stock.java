class Solution {
    public int maxProfit(int[] prices) {

        /**
        
        naive: 
            brute force of am i making profit if i buy today and sell in future
        
        optimal sol: O(n)
        left , right = for loop pointer

        if (prices[right] < prices[left])
            left = right;
        profit? (init at 0)

        
        
        */

        int profit = 0;
        int left = 0;

        for(int right = 0; right < prices.length; right++) {
            if (prices[right] < prices[left]) {
                left = right;
            }
            profit = Math.max(profit, prices[right] - prices[left]);
        }

        return profit;
        
    }
}