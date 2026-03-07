1class Solution {
2    public int singleNumber(int[] nums) {
3        int ans = 0;
4        for(int num : nums){
5            ans = ans ^ num;
6        }   
7        return ans;
8    }
9}