1class Solution {
2
3    public int maxProfit(int k, int[] prices) {
4
5        int n = prices.length;
6        if(n == 1) return 0;
7
8        int[][][] dp = new int[n+1][2][k+1];  
9
10        for(int j = 0 ; j < 2 ; j++){
11            for(int cap = 0 ; cap <= k ; cap++){
12                dp[n][j][cap] = 0;
13            }
14        }
15
16        for(int i = 0 ; i <= n ; i++){
17            for(int j = 0 ; j < 2 ; j++){
18                dp[i][j][0] = 0;
19            }
20        }
21        for(int i = n - 1 ; i >= 0 ; i--){
22            for(int cap = 1 ; cap <= k ; cap++){
23            
24                
25                // skip buying on that day
26                int skipBuy = dp[i+1][1][cap];
27                // buy on that day
28                int buyDay = -prices[i] + dp[i+1][0][cap];
29
30                dp[i][1][cap] = Math.max(skipBuy, buyDay);
31                
32
33                int skipSell = dp[i+1][0][cap];
34                int sellDay = prices[i] + dp[i+1][1][cap-1];
35                dp[i][0][cap] = Math.max(skipSell, sellDay);
36                
37            
38            }
39        }
40
41        return dp[0][1][k];
42        
43    }
44}