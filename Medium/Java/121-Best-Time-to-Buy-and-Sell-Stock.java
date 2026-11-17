class Solution {
    public int maxProfit(int[] prices) {
        int left = 0; 
        int profit = 0; 
        for(int right = 0; right < prices.length; right++) {
            if (prices[right] < prices[left]) {
                left = right;
            }
            profit = Math.max(prices[right] - prices[left], profit);
        }

        return profit;
        
    }
}