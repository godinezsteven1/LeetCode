class Solution {

    public int maxProfit(int[] prices) {

        int left = 0; 
        int maxProfit = 0;
        for(int right = 1; right < prices.length; right++) { 
            if (prices[left] > prices[right]) {
                left = right; 
            }
            int profit = prices[right] - prices[left]; 
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}