class Solution {
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