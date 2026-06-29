1class Solution {
2    public int[] singleNumber(int[] nums) {
3        
4        int n = nums.length;
5        int result = 0;
6        for(int num : nums){
7            result ^= num;
8        }
9
10        int ithBitSet = 0;
11        for(ithBitSet = 0 ; ithBitSet < 32 ; ithBitSet++){
12            if((result & 1) != 0) 
13                break;
14            result = result >> 1;
15        }
16
17        int aSetXor = 0, bSetXor = 0;
18        for(int num : nums){
19            if( ( (num >> ithBitSet) & 1) == 0){
20                aSetXor = aSetXor ^ num;
21            }
22            else{
23                bSetXor = bSetXor ^ num;
24            }
25        }
26
27        return new int[]{aSetXor, bSetXor};
28    }
29}