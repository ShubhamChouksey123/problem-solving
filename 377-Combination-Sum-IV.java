class Solution {
    
    public int combinationSum4(int[] nums, int[] memoCache, int target) {
        if(target == 0) return 1;
        if(target < 0) return 0;
        if(memoCache[target] != -1) return memoCache[target];

        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            count += combinationSum4(nums, memoCache, target - nums[i]);
        }
        memoCache[target] = count;
        return count;
    }   
    
    public int combinationSum4(int[] nums, int target) {

        int[] memoCache = new int[target + 1];
        Arrays.fill(memoCache, -1);
        return combinationSum4(nums, memoCache, target);
    }
}