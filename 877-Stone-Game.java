class Solution {
    
    public int stoneGameUtil(int[] piles, int[][] memoCache, int start, int end) {
        if(start == end) return piles[start];

        if(memoCache[start][end] != -1) return memoCache[start][end];

        int takeLeft = piles[start] - stoneGameUtil(piles, memoCache, start + 1, end);
        int takeRight = piles[end] - stoneGameUtil(piles, memoCache, start, end - 1);

        int optimalValue = Math.max(takeLeft, takeRight);
        memoCache[start][end] = optimalValue;
        return optimalValue;
    }
    
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] memoCache = new int[n][n];
        for(int[] row : memoCache) Arrays.fill(row, -1); 
        return stoneGameUtil(piles, memoCache, 0, n - 1) >= 0;
    }
}