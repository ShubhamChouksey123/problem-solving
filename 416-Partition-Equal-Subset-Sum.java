class Solution {
    public boolean canPartition(int[] nums) {

        int n = nums.length;
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        if((totalSum & 1) != 0) return false;

        int target = totalSum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for(int i = 0 ; i <= n ; i++){
            dp[i][0] = true;
        }

        for(int i = 1 ; i <= n ; i++){
            int index = i - 1;
            for(int sum = 1 ; sum <= target ; sum++){
                dp[i][sum] = dp[i-1][sum];
                if(nums[index] <= sum){
                    dp[i][sum] = dp[i][sum] || dp[i - 1][sum - nums[index]];
                }
            }
        }
        return dp[n][target];    
    }
}