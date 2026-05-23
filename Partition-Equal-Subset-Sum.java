1class Solution {
2    
3    private Boolean[][] memo;
4
5    public boolean canPartitionUtil(int[] nums, int target, int index, int sum) {
6
7        if(index == nums.length){
8            return (sum == target) ? true : false;
9        } 
10
11        if(sum > target){
12            return false;
13        }
14
15        if(memo[index][sum] != null){
16            return memo[index][sum];
17        }
18
19        boolean exclude = canPartitionUtil(nums, target, index + 1, sum);  
20        boolean include = canPartitionUtil(nums, target, index + 1, sum + nums[index]);
21
22        boolean isPossible = include || exclude;
23        memo[index][sum] = isPossible;
24        return isPossible;
25    }
26
27    public boolean canPartition(int[] nums) {
28        int n = nums.length;
29
30        int totalSum = 0;
31        for(int num : nums){
32            totalSum += num;
33        }
34
35        if(totalSum % 2 != 0 ) return false;
36        int target = totalSum / 2 ;
37
38        memo = new Boolean[n][target + 1];
39        return canPartitionUtil(nums, target, 0, 0);
40    }
41}