1class Solution {
2    public int singleNumber(int[] nums) {
3
4        int ans = 0;
5        for(int i = 0 ; i < 32 ; i++){
6            int count = 0;
7            for(int num : nums){
8                count += (1 & (num >> i));
9            }
10            if(count % 3 != 0){
11                ans = ans | ( 1 << i);
12            }
13        }
14
15        return ans;
16    }
17}