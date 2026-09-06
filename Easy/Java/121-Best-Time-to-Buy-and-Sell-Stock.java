class Solution {
    public int maxProfit(int[] prices) { 
        // base cases; no profit, prices empty, 
        // constraints? 
        int max = 0;
        int left = 0;
        for (int right = 0; right < prices.length; right++) {
            if (prices[left] > prices[right]) {
                left = right;
            }
            int profit = prices[right] - prices[left];
            max = Math.max(max, profit);
        }
        return max;
    }
}