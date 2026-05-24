1class Solution {
2    public int coinChange(int[] coins, int amount) {
3
4        int n = coins.length;
5        int[][] dp = new int[n + 1][amount + 1];
6
7        for(int[] row : dp){
8            Arrays.fill(row, Integer.MAX_VALUE);
9        }
10
11        for(int element = 0 ; element <= n ; element++){
12            dp[element][0] = 0;
13        }
14
15        for(int sum = 1 ; sum <= amount ; sum++){
16            for(int element = 1 ; element <= n ; element++){
17                int index = element - 1;
18
19                dp[element][sum] = dp[element - 1][sum];
20
21                if(sum >= coins[index] && dp[element][sum - coins[index]] != Integer.MAX_VALUE){
22                    dp[element][sum] = Math.min(
23                        dp[element][sum], 
24                        1 + dp[element][sum - coins[index]]
25                    );
26                } 
27            }
28        }
29
30        return (dp[n][amount] == Integer.MAX_VALUE) ? -1 : dp[n][amount];
31        
32        
33    }
34}