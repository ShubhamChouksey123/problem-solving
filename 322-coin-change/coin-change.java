class Solution {

    public int coinChangeUtil(int[] coins, int amount) {
        
        if(amount == 0){
            return 0;
        }

        int minCoins = Integer.MAX_VALUE;
        for(int j = 0; j < coins.length ; j++){
            if(amount >= coins[j]){
                int coin = coinChangeUtil(coins, amount-coins[j]);  
                if(coin != -1){
                    minCoins = Math.min(minCoins, coin + 1);
                }  
            }
        }

        if(minCoins == Integer.MAX_VALUE){
            return -1;
        }
        return minCoins;

    }

    public int coinChangeUtil(int[] coins, int amount, int[] dp) {
        
        if(amount < 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }

        if(dp[amount] != Integer.MAX_VALUE){
            return dp[amount];
        }

        int minCoins = Integer.MAX_VALUE;
        for(int j = 0; j < coins.length ; j++){
            if(amount >= coins[j]){
                int coin = coinChangeUtil(coins, amount-coins[j], dp);  
                if(coin != -1){
                    minCoins = Math.min(minCoins, coin + 1);
                }  
            }
        }

        if(minCoins == Integer.MAX_VALUE){
            dp[amount] = -1;
        }
        else{
            dp[amount] = minCoins;
        }
        return dp[amount];

    }

    public int coinChange(int[] coins, int amount) {
        
        // initial recursion
        // return coinChangeUtil(coins, amount);

        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        return coinChangeUtil(coins, amount, dp);
        
    }
}