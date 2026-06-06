1class Solution {
2
3    private int maxProfit(int[] prices, int[][][] dp, int index, int buy, int k) {
4
5        if(k == 0) return 0;
6        if(index == prices.length) return 0;
7
8        if(dp[index][buy][k] != -1)
9            return dp[index][buy][k];
10
11
12        int a = 0, b = 0, optimalValue = 0;
13        if(buy == 1){
14            // skip buying on that day
15            a = maxProfit(prices, dp, index + 1, 1, k);
16
17            // buy on that day
18            b = -prices[index] + maxProfit(prices, dp, index + 1, 0, k);
19        }
20        else{
21            // skip selling on that day
22            a = maxProfit(prices, dp, index + 1, 0, k);
23
24            // sell on that day
25            b = prices[index] + maxProfit(prices, dp, index + 1, 1, k - 1);
26        }
27        
28        optimalValue = Math.max(a, b);
29        dp[index][buy][k] = optimalValue;
30        return optimalValue;
31    }
32
33    public int maxProfit(int k, int[] prices) {
34
35        int n = prices.length;
36        int[][][] dp = new int[n][2][k+1];  
37        for(int[][] matrix : dp){
38            for(int[] row : matrix){
39                Arrays.fill(row, -1);
40            }
41        } 
42
43        return maxProfit(prices, dp, 0, 1, k);
44        
45    }
46}