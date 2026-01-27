1class Solution {
2
3    public int maxProduct(int[] nums) {
4        int n = nums.length, index = 0;
5        int minSoFar = nums[0] , maxSoFar = nums[0], result = nums[0];
6        
7
8        for(int i = 1 ; i < n ; i++){
9            int cur = nums[i]; 
10            int tmp = minSoFar;
11
12            minSoFar = Math.min(cur, Math.min(minSoFar * cur , maxSoFar * cur) );
13            maxSoFar = Math.max(cur, Math.max(tmp * cur , maxSoFar * cur) );
14            result = Math.max(result, maxSoFar);
15        
16        } 
17
18        return result;
19    }
20}