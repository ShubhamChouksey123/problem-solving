1class Solution {
2    public int lengthOfLIS(int[] nums) {
3        int n = nums.length;
4        int[] dp = new int[n];
5        Arrays.fill(dp, 1);
6
7        int maxValue = 1;
8        for(int i = 1 ; i < n ; i++){
9            for(int j = 0 ; j < i ; j++){
10                if(nums[j] < nums[i]){
11                    dp[i] = Math.max(dp[i], 1 + dp[j]);
12                }
13            }
14            maxValue = Math.max(maxValue, dp[i]);
15        }
16
17        
18        return maxValue;
19    }
20}