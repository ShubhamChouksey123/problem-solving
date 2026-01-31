1class Solution {
2    public int missingNumber(int[] nums) {
3
4        int n = nums.length;
5        long totalSum = 0, curSum = 0;
6
7        for(int i = 0 ; i <= n ; i++){
8            totalSum += i; 
9        }
10
11        for(int num : nums){
12            curSum += num;
13        }
14        return (int)(totalSum- curSum);
15        
16    }
17}