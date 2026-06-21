1class Solution {
2    
3    public int maxProfit(int[] prices, int n, int[][] memoCache, int index, int buy) {
4        
5        if(index == n){
6            return 0;
7        }
8
9        if(memoCache[index][buy] != -1) 
10            return memoCache[index][buy];
11
12        int optimalValue = 0; 
13        if(buy == 1){
14            int skipDay = maxProfit(prices, n, memoCache, index + 1, 1);
15            int buyDay = -prices[index] + maxProfit(prices, n, memoCache, index + 1, 0);
16
17            optimalValue = Math.max(skipDay, buyDay);
18        }
19        else{
20            int skipDay = maxProfit(prices, n, memoCache, index + 1, 0);
21            int sellDay = prices[index] + maxProfit(prices, n, memoCache, index + 1, 1);
22
23            optimalValue = Math.max(skipDay, sellDay);
24        }
25        memoCache[index][buy] = optimalValue;
26        return optimalValue;
27    }
28    
29    public int maxProfit(int[] prices) {
30        
31        int n = prices.length;
32        int[][] memoCache = new int[n][2];
33        for(int[] row : memoCache){
34            Arrays.fill(row, -1);
35        }
36        return maxProfit(prices, n, memoCache, 0, 1); 
37    }
38}