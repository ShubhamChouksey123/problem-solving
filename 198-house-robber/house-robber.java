class Solution {

    private int robUtil(int[] nums, int n, int index, int[] dp){

        if(dp[index] != -1){
            return dp[index];
        }
        
        if(index == 0){
            dp[index] = nums[0];
            return dp[index];
        }
        if(index == 1){
            dp[index] = Math.max(nums[0], nums[1]);;
            return dp[index];
        }
    
        int a = 0;
        if(index >= 2){
            a = nums[index] + robUtil(nums, n, index -2, dp);
        }
        int b = robUtil(nums, n, index -1, dp);
        
        dp[index] = Math.max(a, b);
        return dp[index];
    }

    public int rob(int[] nums) {
        
        int n = nums.length; 
        int[] dp = new int[n];

        Arrays.fill(dp, -1);
        robUtil(nums, n, n-1, dp);
        return dp[n-1];
    }
}