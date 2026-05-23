1class Solution {
2    
3    private int[][] memo;
4    private int maxValue;
5
6    private int countWays(int[] nums, int target, int index, int sum) {
7        if(index == nums.length){
8            return (sum == target) ? 1 : 0;
9        }
10        
11        if(memo[index][sum + maxValue] != -1){
12            return memo[index][sum + maxValue];
13        }
14
15        int addWays = countWays(nums, target, index + 1, sum + nums[index]);
16        int subWays = countWays(nums, target, index + 1, sum - nums[index]);
17        
18        int totalWays = addWays + subWays;
19        memo[index][sum + maxValue] = totalWays;
20        return totalWays;
21    }
22    
23    public int findTargetSumWays(int[] nums, int target) {
24
25        int n = nums.length;
26        maxValue = 0;
27        
28        for(int num : nums){
29            maxValue += num;
30        }
31
32        memo = new int[n][ 2 * maxValue + 1];
33        for(int[] row : memo){
34            Arrays.fill(row, -1);
35        }
36        
37        return countWays(nums, target, 0, 0);
38    }
39}