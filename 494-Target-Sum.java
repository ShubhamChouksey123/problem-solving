class Solution {
    
    public int ways(int[] nums, int[] memoCache, int index, int target) {

        if(index >= nums.length) return (target == 0) ? 1 : 0;
        
        // if(memoCache[index] != Integer.MIN_VALUE) return memoCache[index];
        
        
        int a = ways(nums, memoCache, index + 1, target - nums[index]);
        int b = ways(nums, memoCache, index + 1, target + nums[index]);

        int totalWays = a + b;
        memoCache[index] = totalWays;
        return totalWays;
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        
        int[] memoCache = new int[nums.length];
        Arrays.fill(memoCache, Integer.MIN_VALUE);
        ways(nums, memoCache, 0, target);

        return memoCache[0];
    }
}