class Solution {
    private int minCostClimbingStairs(int[] cost, int[] memoCache, int index) {
        
        if(index >= cost.length) return 0;
        if(memoCache[index] != -1) return memoCache[index];

        int a = minCostClimbingStairs(cost, memoCache, index + 1);
        int b = minCostClimbingStairs(cost, memoCache, index + 2);

        int optimalValue = cost[index] + Math.min(a, b);
        memoCache[index] = optimalValue;
        return optimalValue;
    }
    
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        int[] memoCache = new int[n + 1];
        Arrays.fill(memoCache, -1);

        int ans = Math.min(minCostClimbingStairs(cost, memoCache, 0), minCostClimbingStairs(cost, memoCache, 1));
        return ans;
    }
}