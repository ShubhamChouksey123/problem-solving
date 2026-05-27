1class Solution {
2    public int coinChange(int[] coins, int amount) {
3
4        int n = coins.length;
5        int[] dp = new int[amount+1];
6        Arrays.fill(dp, Integer.MAX_VALUE);
7        dp[0] = 0;
8
9        
10
11        for(int element = 1 ; element <= n ; element++){
12            int index = element - 1;
13            for(int j = coins[index]; j <= amount ; j++){
14                if(j >= coins[index] && dp[j - coins[index]] != Integer.MAX_VALUE){
15                    dp[j] = Math.min(
16                        dp[j], 
17                        1 + dp[j - coins[index]]
18                    ) ; 
19                }
20            }
21            
22        } 
23        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
24    }
25}