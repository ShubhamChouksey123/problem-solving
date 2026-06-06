1class Solution {
2    public int maxProfit(int[] prices) {
3
4        int n = prices.length;
5        int startPrice = Integer.MAX_VALUE, profit = 0;
6
7        for(int i = 0 ; i < n ; i++){
8            if(prices[i] < startPrice){
9                startPrice = prices[i]; 
10            }
11            else {
12                profit += prices[i] - startPrice;
13                startPrice = prices[i];
14            }
15        }
16        return profit;
17    }
18}