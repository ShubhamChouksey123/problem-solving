1class Solution {
2    public int maxProfit(int k, int[] prices) {
3
4        int n = prices.length;
5        int[][][] dp = new int[n+1][2][k+1];
6        
7        for(int i = n-1 ; i >= 0 ; i--){
8            for(int cap = 1 ; cap <= k ; cap++){
9
10                int skipBuy = dp[i+1][1][cap];
11                int buyDay = -prices[i] + dp[i+1][0][cap];
12
13                dp[i][1][cap] = Math.max(skipBuy, buyDay);
14
15                int skipSell = dp[i+1][0][cap];
16                int sellDay = prices[i] + dp[i+1][1][cap-1];  
17
18                dp[i][0][cap] = Math.max(skipSell, sellDay);
19            }
20        }
21
22        return dp[0][1][k];
23    }
24}