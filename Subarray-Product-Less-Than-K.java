1class Solution {
2    public int numSubarrayProductLessThanK(int[] nums, int k) {
3
4        int start = 0, count = 0; long prod = 1;
5        for(int end = 0 ; end < nums.length ; end++){
6            prod = prod * nums[end];
7
8            while(start < end && prod >= k){
9                prod = prod / nums[start];
10                start++;
11            }
12
13            if(prod < k){
14                count = count + (end - start + 1); 
15            } 
16        }
17        return count;
18    }
19    
20}