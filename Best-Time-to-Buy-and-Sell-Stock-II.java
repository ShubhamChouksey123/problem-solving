1class Solution {
2    public int maxProfit(int[] prices) {
3
4        int n = prices.length;
5        if(n <= 1)
6            return 0;
7        
8
9        int index = 0, profit = 0;
10        while(index < n){
11            while(index + 1 < n && prices[index] > prices[index+1]){
12                index++;
13            }
14
15            int startIndex = index;
16            while(index + 1 < n && prices[index] < prices[index+1]){
17                index++;
18            }
19            int endIndex = index;
20            profit += prices[endIndex] - prices[startIndex];
21            index++;
22        }
23        return profit;
24    }
25}