1class Solution {
2    public int maxProfit(int[] prices) {
3
4        int n = prices.length, k = 2;
5
6        int[][][] dp = new int[n+1][2][k+1];
7
8        // cap == 0 => dp[.][.][0] = 0;
9        for(int i = 0 ; i <= n ; i++){
10            for(int j = 0 ; j < 2 ; j++){
11                dp[i][j][0] = 0;
12            }
13        }
14
15        // index == n => dp[n][.][.] = 0
16        for(int j = 0 ; j < 2 ; j++){
17            for(int cap = 0 ; cap <= k ; cap++){
18                dp[n][j][cap] = 0;
19            }
20        }
21        
22
23        for(int i = n - 1 ; i >= 0 ; i--){
24            for(int cap = 1 ; cap <= k ; cap++){
25
26                // Buy
27                int skipBuy = dp[i+1][1][cap];
28                int buyDay = -prices[i] + dp[i+1][0][cap];
29                dp[i][1][cap] = Math.max(skipBuy, buyDay);
30
31                int skipSell = dp[i+1][0][cap];
32                int sellDay = prices[i] + dp[i+1][1][cap-1];
33                dp[i][0][cap] = Math.max(skipSell, sellDay);
34            }
35        }
36        return dp[0][1][k];
37    }
38}