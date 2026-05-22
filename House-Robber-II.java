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
11        if(n == 2) return dp[1];
12        
13        // We have included the first element
14        for(int i = 2 ; i < nums.length - 1 ; i++){
15            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
16        }
17        int maxValueWithFirst = dp[n-2];    
18
19        dp[0] = 0;
20        dp[1] = nums[1];
21
22        // We have not included the first element
23        for(int i = 2 ; i < nums.length ; i++){
24            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
25        }
26        int maxValueWithoutFirst = dp[n-1];
27
28        return Math.max(maxValueWithFirst, maxValueWithoutFirst);
29    }
30}