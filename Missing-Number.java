1class Solution {
2    public int missingNumber(int[] nums) {
3
4        int n = nums.length;
5        int result = n;
6        for(int i = 0 ; i < n ; i++){
7            result ^= i; 
8            result ^= nums[i]; 
9        }
10
11        return result;
12    }
13}