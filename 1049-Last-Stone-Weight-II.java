class Solution {

    public int lastStoneWeightII(int[] stones, int[][] memoCache, int index, int remainingWeight) {

        if(index == stones.length) return 0;
        if(remainingWeight == 0) return 0;
        if(memoCache[index][remainingWeight] != -1) return memoCache[index][remainingWeight];

        int notTake = lastStoneWeightII(stones, memoCache, index + 1, remainingWeight);
        int take = 0;
        if(remainingWeight >= stones[index]){
            take = stones[index] + lastStoneWeightII(stones, memoCache, index + 1, remainingWeight - stones[index]);
        }

        int optimalValue = Math.max(take, notTake);
        return memoCache[index][remainingWeight] = optimalValue;
    }

    public int lastStoneWeightII(int[] stones) {

        int n = stones.length;
        int totalSum = 0;
        for(int stone : stones){
            totalSum += stone;
        }

        int target = totalSum / 2;
        
        int[][] memoCache = new int[n][target + 1];
        for(int[] row : memoCache){
            Arrays.fill(row, -1);
        }

        int ans = lastStoneWeightII(stones, memoCache, 0, target);
        return totalSum - (2 * ans);
    }
}