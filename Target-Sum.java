1class Solution {
2
3    private int count;
4
5    private void findTargetSumWaysUtil(int[] nums, int target, int index, int sum) {
6        if(index == nums.length){
7            if(sum == target){
8                count++;
9            }
10            return;
11        }
12
13        findTargetSumWaysUtil(nums, target, index + 1, sum + nums[index]); 
14        findTargetSumWaysUtil(nums, target, index + 1, sum - nums[index]); 
15    }
16    
17    public int findTargetSumWays(int[] nums, int target) {
18        count = 0;
19        findTargetSumWaysUtil(nums, target, 0, 0);
20        return count;
21    }
22}