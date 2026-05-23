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
14        boolean[] dp = new boolean[target + 1];
15        dp[0] = true;
16
17        for(int element = 1 ; element <= n ; element++){
18            int index = element - 1;
19
20            for(int sum = target; sum > 0 ; sum--){
21                
22                if(sum >= nums[index]){                    
23                    dp[sum] = dp[sum] || dp[sum - nums[index]];
24                }
25            }
26        }
27        
28        return dp[target];
29    }
30}