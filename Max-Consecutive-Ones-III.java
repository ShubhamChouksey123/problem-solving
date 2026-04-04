1class Solution {
2    public int longestOnes(int[] nums, int k) {
3        
4        int n = nums.length, countZeros = 0 ;
5        int len = 0, maxLen = 0, start = 0;
6
7
8        for(int end = 0 ; end < n ; end++){
9            if(nums[end] == 0){
10                countZeros++;
11            }
12            
13            while(countZeros > k){
14                if(nums[start] == 0){
15                    countZeros--;
16                }
17                start++;
18            }
19            
20            maxLen = Math.max(end - start + 1, maxLen);
21        }
22        return maxLen;
23
24    }
25}