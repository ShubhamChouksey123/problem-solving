1class Solution {
2
3    public boolean canPartition(int[] nums) {
4        int n = nums.length;
5
6        int totalSum = 0;
7        for(int num : nums){
8            totalSum += num;
9        }
10
11        if(totalSum % 2 != 0 ) return false;
12        int target = totalSum / 2 ;
13
14        boolean[][] dp = new boolean[n+1][target + 1];
15        for(int element = 0 ; element <= n ; element++){
16            dp[element][0] = true;
17        }
18
19        for(int element = 1 ; element <= n ; element++){
20            int index = element - 1;
21
22            for(int sum = 1; sum <= target ; sum++){
23                dp[element][sum] = dp[element - 1][sum];
24
25                if(sum >= nums[index]){
26                    dp[element][sum] = dp[element][sum] || dp[element - 1][sum - nums[index]];
27                }
28            }
29        }
30        
31
32
33        return dp[n][target];
34    }
35}