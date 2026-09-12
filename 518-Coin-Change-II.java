class Solution {
    public int change(int amount, int[] coins) {

        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for(int element = 0 ; element <= n ; element ++){
            dp[element][0] = 1;
        }    

        for(int element = 1 ; element <= n ; element++){
            int index = element - 1;
            for(int sum = 1 ; sum <= amount ; sum++){
                dp[element][sum] = dp[element - 1][sum];

                if(sum >= coins[index]){
                    dp[element][sum] += dp[element][sum - coins[index]];
                } 
            }
        }
        return dp[n][amount];
    }
}