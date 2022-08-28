class Solution {
    public int rob(int[] nums) {
        
        /*-  represent the maximum amount that can be robbed till the ith house */
        int n = nums.length;
        if(n == 1)
            return nums[0];
        if(n == 2)
            return Math.max(nums[0], nums[1]);
        
        
        int[] maxAmount = new int[n];
        maxAmount[0] = nums[0];
        maxAmount[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2 ; i < n ; i++){
            maxAmount[i] = Math.max(maxAmount[i-2] + nums[i], maxAmount[i-1]);
        }
        return maxAmount[n-1];
        
    }
}

/**
Test Cases : 

[1,2,3,1]
[2,7,9,3,1]
[2,1,1,2]
*/