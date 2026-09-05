class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int max = 0;
        for (int right = 0; right < prices.length; right++) {
            if (prices[left] > prices[right]) { // ,1,2
                left = right;
            }
            int profit = prices[right] - prices[left];
            max = Math.max(max, profit);
        }
        return max;
    }
}