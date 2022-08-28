class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length ;
        if(n == 1)
            return nums[0];
        if(n == 2)
            return Math.max(nums[0], nums[1]);
        
        int[] maxAmount = new int[n];
        maxAmount[0] = nums[0];
        maxAmount[1] = Math.max(nums[0], nums[1]);
        for(int i = 2 ; i < n-1 ; i++){
            maxAmount[i] = Math.max(maxAmount[i-2] + nums[i] , maxAmount[i-1]);
        }
        int lastSecondAmount = maxAmount[n-2];
        
        for(int i = 0 ; i < n ; i++)
            maxAmount[i] =0;
        
        maxAmount[1] = nums[1];
        for(int i = 2 ; i < n ; i++){
            maxAmount[i] = Math.max(maxAmount[i-2] + nums[i] , maxAmount[i-1]); 
        }
        int lastAmount = maxAmount[n-1];
        
        return Math.max(lastSecondAmount,lastAmount);
        
    }
}