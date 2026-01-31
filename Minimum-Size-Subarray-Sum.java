1class Solution {
2    public int minSubArrayLen(int target, int[] nums) {
3
4        int start = 0, sum = 0, minLen = Integer.MAX_VALUE;
5
6        for(int end = 0 ; end < nums.length ; end++){
7            sum += nums[end];
8
9            while(start < end && sum - nums[start] >= target){
10                sum -= nums[start];
11                start++;
12            }
13            if(sum >= target){
14                minLen = Math.min(minLen, end - start + 1);
15            }
16            
17        }
18
19        if(minLen == Integer.MAX_VALUE){
20            return 0;
21        }
22        return minLen;
23        
24    }
25}