1class Solution {
2    public int maxProfit(int[] prices) {
3
4        int n = prices.length;
5        int[][] dp = new int[n+2][2];
6
7
8        // n == 0 => dp[n][.] = 0
9        for(int j = 0 ; j < 2 ; j++){
10            dp[n][j] = 0;
11        }
12
13        for(int i = n - 1; i >= 0 ; i--){
14            // Buy
15            // not buying on that day
16            int skipBuyDay = dp[i+1][1];
17            // Buy stock on that day
18            int buyDay = -prices[i] + dp[i+1][0];
19
20            dp[i][1] = Math.max(skipBuyDay, buyDay);
21
22            // Sell
23            // Not selling on that day
24            int skipSellDay = dp[i+1][0];
25            // Sell stock on that day
26            int sellDay = prices[i] + dp[i+2][1];
27            
28            dp[i][0] = Math.max(skipSellDay, sellDay);
29        }
30        return dp[0][1];
31    }
32}