class Solution {
    /**
    Constraints: 
        positive integer as input, empty array, largest number, biggest price.

    naive: 
        brute force where at each number we compute a running max of what is the profit

    optimal:
        prices = [7,1,5,3,6,4]

        we buy at 7 and see 1 is cheaper ... other words: why would i buy at 7 when i can buy at 1... 
        but if the number is more then curr profit running max profit two pointer solution 


        int left = 0; // buy
        int profit = 0;

        for(int right = 0; right < prices.length; right++) {
            if (prices[left] > prices[right]) {
                left = right;
                // left = 1 right = 1
            }
            // here now prices[right] > prices[left] aka profit 
            profit = Math.max(profit, prices[right] - prices[left]);
        }

        return profit; 
        
    
    
    
    */
    public int maxProfit(int[] prices) {
        int left = 0;
        int profit = 0;

        for(int right = 0; right < prices.length; right++) {
            if (prices[left] > prices[right]) {
                left = right;
            }
            profit = Math.max(profit, prices[right] - prices[left]);
       }

       return profit;
    }
}