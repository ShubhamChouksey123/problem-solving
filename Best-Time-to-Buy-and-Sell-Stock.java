1class Solution {
2    public int maxProfit(int[] prices) {
3
4        int n = prices.length;
5        int maxProfit = 0, maxSellingPrice = prices[n-1];
6        for(int i = n - 2 ; i >= 0 ; i--){
7            maxProfit = Math.max(maxProfit, maxSellingPrice - prices[i]);
8            maxSellingPrice = Math.max(maxSellingPrice, prices[i]);
9        }
10        return maxProfit;
11    }
12}