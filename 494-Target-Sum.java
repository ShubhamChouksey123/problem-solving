class Solution {

    private int findTargetSumWays(int[] nums, int total, int[][] memoCache, int target, int sum, int index) {

       if(index >= nums.length) return (target == sum) ? 1 : 0;
       if(memoCache[total + sum][index] != Integer.MIN_VALUE) return memoCache[total + sum][index];

        int plus = findTargetSumWays(nums, total, memoCache, target, sum + nums[index], index + 1);
        int minus = findTargetSumWays(nums, total, memoCache, target, sum - nums[index], index + 1);

        int totalWays = plus + minus;
        memoCache[total + sum][index] = totalWays;
        return totalWays;

    }

    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;
        int total = 0;
        for(int num : nums){
            total += num;
        }

        int[][] memoCache = new int[(2 * total) + 1][n];
        for(int[] row : memoCache){
            Arrays.fill(row, Integer.MIN_VALUE);
        }
    
        return findTargetSumWays(nums, total, memoCache, target, 0, 0); 
    }
}