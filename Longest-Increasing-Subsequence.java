1class Solution {
2    public int lengthOfLIS(int[] nums) {
3        
4        int n = nums.length;
5        int[] dp = new int[n];
6        Arrays.fill(dp, 1);
7
8        int maxValue = 1;
9        for(int i = 1 ; i < n ; i++){
10            for(int j = 0 ; j < i ; j++){
11                if(nums[j] < nums[i]){
12                    dp[i] = Math.max(dp[i], 1 + dp[j]);
13                }
14            }
15            maxValue = Math.max(maxValue, dp[i]);
16        }
17        return maxValue;
18    }
19}