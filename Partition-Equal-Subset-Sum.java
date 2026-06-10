1class Solution {
2    
3    public boolean canPartition(int[] nums, int target, Boolean[][] dp, int index, int sum) {
4        
5        if(sum == target){
6            return true;
7        }else if(sum > target){
8            return false;
9        }
10
11        if(index == nums.length){
12            return sum == target ? true : false;
13        }
14
15        if(dp[index][sum] != null)
16            return dp[index][sum];
17
18        boolean a = canPartition(nums, target, dp, index + 1, sum); 
19        boolean b = canPartition(nums, target, dp, index + 1, sum + nums[index]); 
20
21        Boolean result = a | b;
22        dp[index][sum] = result;
23        return result;
24    }
25    
26    public boolean canPartition(int[] nums) {
27        
28        int n = nums.length; int totalSum = 0;;
29        for(int num : nums){
30            totalSum += num;
31        }
32        if(totalSum % 2 != 0) return false;
33
34        Boolean[][] dp = new Boolean[n][totalSum/2];
35        
36        return canPartition(nums, totalSum/2, dp, 0, 0);
37
38    }
39}