class Solution {

    public long minCoins(int[] coins, long[] memoCache, int amount) {
        
        if(amount == 0) return 0;
        if(memoCache[amount] != -1) return memoCache[amount];

        long minCoin = Integer.MAX_VALUE;
        for(int coin : coins){
            if(coin <= amount){
                minCoin = Math.min(minCoin, 1 + minCoins(coins, memoCache, amount - coin));
            }
        }
        return memoCache[amount] = minCoin;
    }

    public int coinChange(int[] coins, int amount) {
        
        int n = coins.length;
        long[] memoCache = new long[amount + 1];
        Arrays.fill(memoCache, -1);
        long minCoin = minCoins(coins, memoCache, amount);

        if(memoCache[amount] == Integer.MAX_VALUE) return -1; 
        return (int)minCoin ;
        
    }
}