class Solution {
    
    private int stoneGameIII(int[] stoneValue, int n, int[] memoCache, int start) {
        
        if(start >= n) return 0;
        if(memoCache[start] != -1) return memoCache[start];

        int takeOneStone = Integer.MIN_VALUE, takeTwoStone = Integer.MIN_VALUE, takeThreeStone = Integer.MIN_VALUE;
        if(start < n) {
            takeOneStone = stoneValue[start] - stoneGameIII(stoneValue, n, memoCache, start + 1);
        }
        if(start + 1 < n) {
            takeTwoStone = stoneValue[start] + stoneValue[start + 1] - stoneGameIII(stoneValue, n, memoCache, start + 2);
        }
        if(start + 2 < n) {
            takeThreeStone = stoneValue[start] + stoneValue[start + 1] + stoneValue[start + 2] - stoneGameIII(stoneValue, n, memoCache, start + 3);
        }

        int optimalValue = Math.max(takeOneStone, Math.max(takeTwoStone, takeThreeStone));
        memoCache[start] = optimalValue;
        return optimalValue;
    }
    
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] memoCache = new int[n];
        Arrays.fill(memoCache, -1);

        int ans = stoneGameIII(stoneValue, n, memoCache, 0);
        if(ans > 0) return "Alice";
        else if(ans == 0) return "Tie";
        return "Bob";
    }
}