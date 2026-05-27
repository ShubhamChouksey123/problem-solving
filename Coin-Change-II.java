1class Solution {
2    public int change(int amount, int[] coins) {
3
4        int n = coins.length;
5        int[] dp = new int[amount+1];
6        Arrays.fill(dp, 0);
7        dp[0] = 1;
8
9        
10        for(int element = 1 ; element <= n ; element++ ){
11            int index = element - 1;
12            for(int j = 1 ; j <= amount ; j++){
13                if(j >= coins[index]){
14                    dp[j] += dp[j - coins[index]];
15                } 
16            }
17        }
18
19        return dp[amount];
20    }
21}