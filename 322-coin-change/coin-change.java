class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int k = coins.length;
        int[][] dp = new int[amount+1][k];
        
        for(int[] arr : dp){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for(int j = 0 ; j < k ; j++){
            dp[0][j] = 0;
        }

        for(int i = 1 ; i <= amount ; i++){
            for(int j = 0 ; j < k ; j++){
                dp[i][j] = Integer.MAX_VALUE;
                int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
                if(j >= 1 && dp[i][j-1] != Integer.MAX_VALUE){
                    a = dp[i][j-1];
                }
                if(i >= coins[j] && dp[i-coins[j]][j] != Integer.MAX_VALUE){
                    b = 1 + dp[i-coins[j]][j];
                }

                dp[i][j] = Math.min(a, b);
            }
        }

        if(dp[amount][k-1] == Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount][k-1];
    }
}