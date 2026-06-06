1class Solution {
2
3    private int maxProfit(int[] prices, int[][][] dp, int index, int buy, int cap) {
4        
5        if(index == prices.length) return 0;
6        if(cap == 0) return 0;
7
8        if(dp[index][buy][cap] != -1)
9            return dp[index][buy][cap];
10
11        int optimalValue = 0;
12        if(buy == 1){
13            
14            int skipDay = maxProfit(prices, dp, index + 1, 1, cap);
15            int buyDay = -prices[index] + maxProfit(prices, dp, index + 1, 0, cap);
16            optimalValue = Math.max(skipDay, buyDay);
17        }
18        else{
19            int skipDay = maxProfit(prices, dp, index + 1, 0, cap);
20            int sellDay = prices[index] + maxProfit(prices, dp, index + 1, 1, cap - 1);
21            optimalValue = Math.max(skipDay, sellDay);
22        }
23        dp[index][buy][cap] = optimalValue;
24        return optimalValue;
25    }
26
27    public int maxProfit(int[] prices) {
28        
29        int n = prices.length;
30        int k = 2;
31        int[][][] dp = new int[n][2][k+1];
32        for(int[][] matrix : dp){
33            for(int[] row : matrix){
34                Arrays.fill(row, -1);
35            }
36        }
37
38        return maxProfit(prices, dp, 0, 1, k) ;
39
40    }
41}