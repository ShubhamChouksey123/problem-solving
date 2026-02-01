1class Solution {
2    public int numberOfSubarrays(int[] nums, int k) {
3        
4        return atMost(nums, k) - atMost(nums, k - 1);
5
6    }
7
8    public int atMost(int[] nums, int k) {
9
10        if(k < 0) 
11            return 0;
12        
13        int start = 0, countOdd = 0, ans = 0;
14        for (int end = 0; end < nums.length; end++) {
15
16            if(nums[end] %2 != 0){
17                countOdd++;
18            }
19
20            while(start <= end && countOdd > k){
21                if(nums[start] %2 != 0){
22                    countOdd--;
23                }
24                start++;
25            }
26            ans = ans + (end - start + 1);
27        }
28        return ans; 
29        
30    }
31}