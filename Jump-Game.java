1class Solution {
2    public boolean canJump(int[] nums) {
3
4        int n = nums.length;
5        
6        int maxReach = 0;
7
8        for(int i = 0; i < n ; i++){
9            
10            if(i > maxReach) return false;
11
12            maxReach = Math.max(maxReach, i + nums[i]);
13        } 
14        
15        return maxReach >= n - 1 ;
16    }
17}