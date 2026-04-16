class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int minCost = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minCost);
            minCost = Math.min(minCost, prices[i]);
        }

        return maxProfit;
    }
}
