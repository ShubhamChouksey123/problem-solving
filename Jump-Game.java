1class Solution {
2    public boolean canJump(int[] nums) {
3
4        int n = nums.length;
5        boolean[] canReach = new boolean[n];
6        canReach[0] = true;
7
8        for(int i = 0; i < n ; i++){
9            if(canReach[i]){
10                for(int j = 1 ; j <= nums[i] && i + j < n ; j++){
11                    canReach[i + j] = true;
12                }
13            }
14        } 
15        
16        return canReach[n-1];
17    }
18}