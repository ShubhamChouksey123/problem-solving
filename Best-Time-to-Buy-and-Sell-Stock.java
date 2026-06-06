1class Solution {
2    public int maxProfit(int[] prices) {
3
4        int n = prices.length;
5        int maxLeft = prices[n-1], maxProfit = 0;
6
7        for(int i = n - 2 ; i >= 0 ; i--){
8            maxProfit = Math.max(maxProfit, maxLeft - prices[i]);
9            maxLeft = Math.max(maxLeft, prices[i]);
10        }
11        return maxProfit;   
12    }
13}