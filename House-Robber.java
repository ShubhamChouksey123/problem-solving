1class Solution {
2    public int rob(int[] nums) {
3        
4        int n = nums.length;
5        if(n == 1) return nums[0];
6
7        int[] dp = new int[n];
8        dp[0] = nums[0];
9        dp[1] = Math.max(nums[0], nums[1]);
10
11        for(int i = 2 ; i < nums.length ; i++){
12            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
13        }
14        return dp[n-1];
15    }
16}