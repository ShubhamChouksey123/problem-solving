1class Solution {
2
3    private int maxProfit(int[] prices, int[][] dp, int index, int buy) {
4
5        if(index >= prices.length) return 0;
6
7        if(dp[index][buy] != -1)
8            return dp[index][buy];
9
10        int optimalValue = 0;
11        if(buy == 1){
12            int skipDay = maxProfit(prices, dp, index + 1, 1); 
13            int buyDay = -prices[index] + maxProfit(prices, dp, index + 1, 0); 
14            optimalValue = Math.max(skipDay, buyDay);
15        }
16        else{
17            int skipDay = maxProfit(prices, dp, index + 1, 0); 
18            int sellDay = prices[index] + maxProfit(prices, dp, index + 2, 1); 
19            optimalValue = Math.max(skipDay, sellDay);
20        }
21        dp[index][buy] = optimalValue;
22        return optimalValue;
23    }
24
25    public int maxProfit(int[] prices) {
26
27        int n = prices.length;
28        int[][] dp = new int[n][2];
29        for(int[] row : dp){
30            Arrays.fill(row, -1);
31        }
32
33        return maxProfit(prices, dp, 0, 1);
34    }
35}