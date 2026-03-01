1class Solution {
2    public int singleNonDuplicate(int[] nums) {
3        int result = 0;
4        for(int num : nums){
5            result = result ^ num;
6        }    
7        return result;
8    }
9}