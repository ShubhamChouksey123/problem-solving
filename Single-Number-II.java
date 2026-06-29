1class Solution {
2    public int singleNumber(int[] nums) {
3
4        int n = nums.length;
5        int ans = 0;
6
7        for(int i = 0 ; i < 32 ; i++){
8            int countSetBit = 0;
9            for(int j = 0 ; j < n ; j++){
10                if(((nums[j] >> i) & 1) != 0) countSetBit++;
11                
12            }
13            if(countSetBit % 3 != 0){
14                ans = ans | (1 << i);
15            }
16        }
17        return ans;
18        
19    }
20}