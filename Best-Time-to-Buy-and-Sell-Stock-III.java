1class Solution {
2    
3    private int maxProfit(int[] prices, int[][][] memoCache, int index, int buy, int k) {
4        
5        if(index == prices.length || k == 0){
6            return 0;
7        }
8
9        if(memoCache[index][buy][k] != -1){
10            return memoCache[index][buy][k];
11        }
12
13        int optimalValue = 0;
14        if(buy == 1){
15            int a = maxProfit(prices, memoCache, index + 1, 1, k);
16            int b = -prices[index] + maxProfit(prices, memoCache, index + 1, 0, k); 
17
18            optimalValue = Math.max(a, b);
19        }
20        else{
21            int a = maxProfit(prices, memoCache, index + 1, 0, k);
22            int b = prices[index] + maxProfit(prices, memoCache, index + 1, 1, k - 1); 
23
24            optimalValue = Math.max(a, b);
25        }
26
27        memoCache[index][buy][k] = optimalValue;
28        return optimalValue;
29    }
30    
31    public int maxProfit(int[] prices) {
32        
33        int n = prices.length; 
34        int[][][] memoCache = new int[n][2][3];
35        for(int[][] slice : memoCache){
36            for(int[] row : slice){
37                Arrays.fill(row, -1);
38            }
39        }
40
41        return maxProfit(prices, memoCache, 0, 1, 2);
42    }
43}