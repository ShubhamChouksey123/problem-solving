1class Solution {
2    public int rob(int[] nums) {
3
4        int n = nums.length;
5        if(n == 1) return nums[0];
6        int[] dp = new int[n];
7        
8
9        dp[0] = nums[0]; dp[1] = Math.max(nums[0], nums[1]);
10        for(int i = 2 ; i < n - 1 ; i++){
11            dp[i] = Math.max( nums[i] + dp[i-2] , dp[i-1] );
12        }
13        int firstCasemaxValue = dp[n-2];
14
15        dp[0] = 0; dp[1] = nums[1];
16        for(int i = 2 ; i < n ; i++){
17            dp[i] = Math.max( nums[i] + dp[i-2] , dp[i-1] );
18        }
19        int secondCasemaxValue = dp[n-1];
20        return Math.max(firstCasemaxValue, secondCasemaxValue);
21    }
22}