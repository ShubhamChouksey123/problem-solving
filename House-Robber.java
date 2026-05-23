1class Solution {
2    
3    private int[] memo;
4
5    private int robUtil(int[] nums, int index) {
6
7        if(index >= nums.length){
8            return 0;
9        }
10
11        if(memo[index] != -1){
12            return memo[index];
13        }
14            
15        int exclude = robUtil(nums, index + 1);
16        int include = nums[index] + robUtil(nums, index + 2);
17
18        int optimal = Math.max(exclude, include);
19
20        memo[index] = optimal;
21        return optimal;
22    }
23    
24    public int rob(int[] nums) {
25
26        int n = nums.length;
27        memo = new int[n];
28        Arrays.fill(memo, -1);
29
30        return robUtil(nums, 0);
31    }
32}