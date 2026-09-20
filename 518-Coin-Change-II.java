class Solution {

    public int change(int[] coins, int[][] memoCache, int index, int amount) {

        if(amount < 0) return 0;
        if(amount == 0) return 1;
        if(memoCache[index][amount] != -1) return memoCache[index][amount];
        
        int totalWays = 0;
        for(int i = index ; i < coins.length ; i++){
            totalWays += change(coins, memoCache, i, amount - coins[i]);
        }

        return memoCache[index][amount] = totalWays;
    }

    public int change(int amount, int[] coins) {

        int n = coins.length;
        int[][] memoCache = new int[n][amount + 1];
        for(int[] row : memoCache){
            Arrays.fill(row, -1);
        }

        return change(coins, memoCache, 0, amount);
    }
}