1class Solution {
2
3    private int maxProfit(int[] prices, int fee, int[][] dp, int index, int buy) {
4
5        if(index == prices.length) return 0;
6        if(dp[index][buy] != -1)
7            return dp[index][buy];
8
9        int optimalValue = 0;
10        if(buy == 1){
11            int skipDay = maxProfit(prices, fee, dp, index + 1, 1);
12            int buyDay = -prices[index] + maxProfit(prices, fee, dp, index + 1, 0);
13            optimalValue = Math.max(skipDay, buyDay);
14        }
15        else{
16            int skipDay = maxProfit(prices, fee, dp, index + 1, 0);
17            int sellDay = prices[index] - fee + maxProfit(prices, fee, dp, index + 1, 1);
18            optimalValue = Math.max(skipDay, sellDay);
19        }
20        dp[index][buy] = optimalValue;
21        return optimalValue;
22    }
23
24    public int maxProfit(int[] prices, int fee) {
25
26        int n = prices.length;
27        int[][] dp = new int[n][2];
28        for(int[] row : dp){
29            Arrays.fill(row, -1);
30        }
31
32        return maxProfit(prices, fee, dp, 0, 1); 
33    }
34}