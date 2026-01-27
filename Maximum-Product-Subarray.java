1class Solution {
2
3    public int maxProduct(int[] nums) {
4        int n = nums.length, index = 0;
5        long[] minProd = new long[n];
6        long[] maxProd = new long[n];
7        minProd[0] = nums[0];
8        maxProd[0] = nums[0];
9        if(nums[0] == 0){
10            minProd[0] = 1; maxProd[0] = 1; 
11        }
12
13        for(int i = 1 ; i < n ; i++){
14            if(nums[i] == 0){
15                minProd[i] = 1; maxProd[i] = 1; 
16                continue;
17            }
18            long a = nums[i]*minProd[i-1];
19            long b = nums[i]*maxProd[i-1];
20            minProd[i] = Math.min(Math.min(a, b), (long)nums[i]);
21            maxProd[i] = Math.max(Math.max(a, b), (long)nums[i]);
22        }
23
24        long max = Long.MIN_VALUE;
25        for(int i = 0 ; i < n ; i++){
26            if(nums[i] != 0){
27                max = Math.max(max, maxProd[i]);
28            }else{
29                max = Math.max(max, 0);
30            } 
31        }
32
33        return (int)max;
34    }
35}