1class Solution {
2    public int maxProduct(int[] nums) {
3        
4        int n = nums.length;
5        int[] minProd = new int[n];
6        int[] maxProd = new int[n];
7        minProd[0] = nums[0]; maxProd[0] = nums[0];
8        int maxProduct = maxProd[0];
9
10        for(int i = 1 ; i < n ; i++){
11            minProd[i] = Math.min( nums[i] , Math.min( maxProd[i-1] * nums[i]  , minProd[i-1] * nums[i] ) );
12            maxProd[i] = Math.max( nums[i] , Math.max( maxProd[i-1] * nums[i]  , minProd[i-1] * nums[i] ) );
13            maxProduct = Math.max(maxProduct, maxProd[i]);
14        }
15
16        return maxProduct;
17    }
18}