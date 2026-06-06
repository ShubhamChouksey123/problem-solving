1class Solution {
2    
3    public int maxProfit(int[] prices, int[][] dp, int index, boolean buy) {
4        if(index == prices.length)
5            return 0;
6
7        if(buy && dp[index][1] != -1){
8            return dp[index][1];
9        }
10        if(!buy && dp[index][0] != -1){
11            return dp[index][0];
12        }
13
14        int a = 0, b = 0, optimalValue = 0;
15        if(buy){
16            // skip buying on that day
17            a = maxProfit(prices, dp, index + 1, true);
18
19            // buy on that day
20            b = -prices[index] + maxProfit(prices, dp, index + 1, false);
21            
22            optimalValue = Math.max(a, b);
23            dp[index][1] = optimalValue;
24        }
25        else{
26
27            // skip selling on that day
28            a = maxProfit(prices, dp, index + 1, false);
29
30            // sell on that day
31            b = prices[index] + maxProfit(prices, dp, index + 1, true);
32
33            optimalValue = Math.max(a, b);
34            dp[index][0] = optimalValue;
35        }
36        return optimalValue;
37    }
38    
39    public int maxProfit(int[] prices) {
40
41        int n = prices.length;
42        int[][] dp = new int[n][2];
43        for(int[] row : dp){
44            Arrays.fill(row, -1);
45        }
46        return maxProfit(prices, dp, 0, true);
47    }
48}