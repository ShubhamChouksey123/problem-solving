1class Solution {
2    public int lengthOfLIS(int[] nums) {
3        int n = nums.length;
4        int[] dp = new int[n];
5        Arrays.fill(dp, 1);
6
7        for(int i = 1 ; i < n ; i++){
8            for(int j = 0 ; j < i ; j++){
9                if(nums[j] < nums[i]){
10                    dp[i] = Math.max(dp[i], 1 + dp[j]);
11                }
12            }
13        }
14
15        int maxValue = 1;
16        for(int val : dp){
17            maxValue = Math.max(maxValue, val);
18        }
19        return maxValue;
20    }
21}