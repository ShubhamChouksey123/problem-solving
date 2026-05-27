1class Solution {
2    public int change(int amount, int[] coins) {
3
4        int n = coins.length;
5        int[][] dp = new int[n+1][amount+1];
6        for(int[] row : dp){
7            Arrays.fill(row, 0);
8        }
9
10        for(int i = 0 ; i <= n ; i++){
11            dp[i][0] = 1;
12        }
13
14        for(int element = 1 ; element <= n ; element++ ){
15            int index = element - 1;
16            for(int j = 1 ; j <= amount ; j++){
17                dp[element][j] = dp[element - 1][j];
18                if(j >= coins[index] && dp[element][j - coins[index]] != 0){
19                    
20                    dp[element][j] += dp[element][j - coins[index]];
21                } 
22            }
23        }
24
25        return dp[n][amount];
26    }
27}