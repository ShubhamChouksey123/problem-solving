class Solution {
    
    public int maxProfit(int[] prices, int[][] memoCache, int index, int buy) {

        if(index == prices.length) return 0;
        if(memoCache[index][buy] != -1) return memoCache[index][buy];

        int optimalValue = 0;
        if(buy == 0){
            // buy on that day
            int a = -prices[index] + maxProfit(prices, memoCache, index + 1, 1);

            // skip buying on that day
            int b = maxProfit(prices, memoCache, index + 1, buy);
            optimalValue = Math.max(a, b);
        }
        else {
            // sell that holding stock on that day
            int a = prices[index] + maxProfit(prices, memoCache, index + 1, 0);

            // skip selling stock on that day
            int b = maxProfit(prices, memoCache, index + 1, buy);
            optimalValue = Math.max(a, b);
        }
        return memoCache[index][buy] = optimalValue;
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[][] memoCache = new int[n][2];
        for(int[] row : memoCache){
            Arrays.fill(row, -1);
        }
        return maxProfit(prices, memoCache, 0, 0);
    }
}