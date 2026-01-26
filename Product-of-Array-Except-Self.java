1class Solution {
2    public int[] productExceptSelf(int[] nums) {
3        
4        int prod = 1, n = nums.length;
5        int[] ans = new int[n];
6
7        for(int i = 0 ; i < n ; i++){
8            ans[i] = prod;
9            prod *= nums[i];
10        }
11
12        prod = 1;
13        for(int i = n-1 ; i>= 0 ; i--){
14            ans[i] = prod * ans[i];
15            prod *= nums[i];
16        }
17
18        return ans;
19    }
20}