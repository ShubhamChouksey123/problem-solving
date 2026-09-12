class Solution {
    
    public int maxSum(int[] stones, int target, int[][] memoCache, int index, int sum) {
            
        if(index == stones.length) return 0;
        if(sum == target) return 0;
        if(memoCache[index][sum] != -1) return memoCache[index][sum];

        int notTake = maxSum(stones, target, memoCache, index + 1, sum);
        int take = 0;
        if(stones[index] + sum <= target){
            take = stones[index] + maxSum(stones, target, memoCache, index + 1, sum + stones[index]);
        }

        int optimalValue = Math.max(take, notTake);
        memoCache[index][sum] = optimalValue;
        return optimalValue;
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
        int maxHalfSum = maxSum(stones, target, memoCache, 0, 0);

        return totalSum - (maxHalfSum * 2);
    }
}