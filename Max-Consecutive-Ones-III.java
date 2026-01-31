1class Solution {
2    public int longestOnes(int[] nums, int k) {
3
4        int start = 0, maxLen = 0, zeroCount = 0;
5        for(int end = 0 ; end < nums.length ; end++){
6            if(nums[end] == 0)
7                zeroCount ++;
8
9            while(zeroCount > k){
10                if(nums[start] == 0){
11                    zeroCount --;
12                }
13                start++;
14            }
15            maxLen = Math.max(maxLen, end - start + 1);
16        }
17
18        return maxLen;
19        
20    }
21}