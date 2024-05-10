class Solution {
    
    public int coinChange(int[] coins, int amount) {

        int k = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

//        for (int j = 0; j < k; j++) {
//            dp[coins[j]] = 1;
//        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < k; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }

        // System.out.println("dp : " + Arrays.toString(dp));
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        return dp[amount];

    }

}