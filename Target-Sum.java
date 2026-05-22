1class Solution {
2
3    private Map<String, Integer> memo;
4
5    private int findTargetSumWaysUtil(int[] nums, int target, int index, int sum) {
6        
7        if(index == nums.length){
8            if(sum == target){
9                return 1;
10            }
11            return 0;
12        }
13
14        String key = index + "," + sum; 
15        if(memo.containsKey(key)){
16            return memo.get(key);
17        }
18
19        
20        int minus = findTargetSumWaysUtil(nums, target, index + 1, sum - nums[index]);
21        int add = findTargetSumWaysUtil(nums, target, index + 1, sum + nums[index]); 
22        
23        memo.put(key, minus + add);
24        return minus + add;
25    }
26    
27    public int findTargetSumWays(int[] nums, int target) {
28        int n = nums.length, totalSum = 0;
29
30        memo = new HashMap<>();
31        return findTargetSumWaysUtil(nums, target, 0, 0);
32    }
33}