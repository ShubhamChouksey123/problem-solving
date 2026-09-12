class Solution {

    private boolean canPartition(int[] nums, Boolean[][] memoCache, int index, int target){

        if(index >= nums.length) return (target == 0) ? true : false;
        if(target < 0) return false;
        if(memoCache[index][target] != null) return memoCache[index][target];

        boolean take = canPartition(nums, memoCache, index + 1, target - nums[index]);
        boolean notTake = canPartition(nums, memoCache, index + 1, target);

        boolean ans = take | notTake;
        memoCache[index][target] = ans;

        return ans;
    }

    public boolean canPartition(int[] nums) {

        int n = nums.length;
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        } 

        if(totalSum % 2 != 0) return false;
        int target = totalSum / 2;

        Boolean[][] memoCache = new Boolean[n][target + 1];
        

        return canPartition(nums, memoCache, 0, totalSum / 2);
        
    }
}